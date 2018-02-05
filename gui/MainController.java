import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class MainController implements ActionListener{

  private final int CODE_ROCK = 0;
  private final int CODE_SCISSORS = 1;
  private final int CODE_PAPER = 2;

  private int te1, te2; //出した手 0:グー, 1:チョキ, 2:パー
  private int sen; //宣言した手 0:グー, 1:チョキ, 2:パー
  private int play1_p = 5, play2_p = 5; //持ち点
  private boolean seme_flag = true; //攻めが1ならtrue, 2ならfalse
  private boolean sengen_flag = true; //trueで宣言
  private boolean p1_flag = true; //trueでplay1のターン
  private int kekka; //jankenの結果を保存

  private MainFrame mainFrame = new MainFrame();

  public MainController(){
    //ぐー、ちょき、パーボタンのリスナーを設定
    mainFrame.getButtonRock().addActionListener(this);
    mainFrame.getButtonScissors().addActionListener(this);
    mainFrame.getButtonPaper().addActionListener(this);
  }

  //押されたボタンとじゃんけんコードのマッピング
  private Map<Object, Integer> rpsMap;
  {
    //オブジェクトの等価で判断したいので、IdentityHashMapを使う。
    this.rpsMap = new IdentityHashMap<Object, Integer>();
    this.rpsMap.put(this.mainFrame.getButtonRock(),0);
    this.rpsMap.put(this.mainFrame.getButtonScissors(),1);
    this.rpsMap.put(this.mainFrame.getButtonPaper(),2);
    this.mainFrame.setSubTitle("プレイヤー1の宣言");
  }

  public int janken(){
    if(te1 == 0 && te2 == 1){
        return 1;
    }else if(te1 == 1 && te2 == 2){
        return 1;
    }else if(te1 == 2 && te2 == 0){
        return 1;
    }else if(te1 == te2){
        return 0;
    }else{
          //それ以外はプレイヤー2の勝ち
        return 2;
    }
  }

  /**
   * じゃんけんボタン押下時のアクションリスナー
   */
  @Override
  public void actionPerformed(ActionEvent e){
    //押したボタンからコード値を取得
    int result = this.rpsMap.get(e.getSource());

    if(sengen_flag) {
      // if(seme_flag) {
      //   this.mainFrame.setSubTitle("プレイヤー1の宣言");
      // }
      // else {
      //   this.mainFrame.setSubTitle("プレイヤー2の宣言");
      // }
      sen = result;
      sengen_flag = !sengen_flag;
      this.mainFrame.setSubTitle("プレイヤー1の手");
    }
    else {
      if(p1_flag) {
        te1 = result;
        this.mainFrame.setSubTitle("プレイヤー2の手");
      }
      else {
        te2 = result;
        kekka = janken();
        if(kekka == 0) {
          if(seme_flag) {
            this.mainFrame.setSubTitle("プレイヤー1の宣言");
          }
          else {
            this.mainFrame.setSubTitle("プレイヤー2の宣言");
          }
          seme_flag = !seme_flag;
        }
        else {
          if(kekka == 1) {
            if(seme_flag) {
              if(te1 == sen) {
                play2_p -= 2;
              }
              else {
                play2_p --;
              }
            }
          }
          else {
            if(!seme_flag) {
              if(te2 == sen) {
                play1_p -= 2;
              }
              else {
                play1_p --;
              }
            }
          }
          if(seme_flag) {
            this.mainFrame.setSubTitle("プレイヤー2の宣言");
          }
          else {
            this.mainFrame.setSubTitle("プレイヤー1の宣言");
          }
        }
        sengen_flag = !sengen_flag;
        seme_flag = !seme_flag;
      }
      p1_flag = !p1_flag;
    }
    if(play1_p<=0) {
      this.mainFrame.setSubTitle("プレイヤー2の勝ち！");
      int play1_p = 5, play2_p = 5;
      boolean seme_flag = true;
      boolean sengen_flag = true;
      boolean p1_flag = true;
    }
    else if(play2_p<=0) {
      this.mainFrame.setSubTitle("プレイヤー1の勝ち！");
    }
    this.mainFrame.setPointLabel(play1_p,play2_p);
  }
}
