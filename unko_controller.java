import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class unko_controller implements ActionListener{

  // private final String CODE_ROCK = "グー";
  // private final String CODE_SCISSORS = "チョキ";
  // private final String CODE_PAPER = "パー";

  private MainFrame mainFrame = new MainFrame();

  public MainController(){
    //ぐー、ちょき、パーボタンのリスナーを設定
    mainFrame.getButtonRock().addActionListener(this);
    mainFrame.getButtonScissors().addActionListener(this);
    mainFrame.getButtonPaper().addActionListener(this);
  }

  //勝ちパターンを文字列化しておく 自分のじゃんけん + ":" + CPUのじゃんけん
  // private List<String> victoryList;
  // {
  //   this.victoryList = new ArrayList<String>();
  //   this.victoryList.add(this.CODE_ROCK + ":" + this.CODE_SCISSORS);
  //   this.victoryList.add(this.CODE_SCISSORS + ":" + this.CODE_PAPER);
  //   this.victoryList.add(this.CODE_PAPER + ":" + this.CODE_ROCK);
  // }

  //押されたボタンとじゃんけんコードのマッピング
  // private Map<Object, String> rpsMap;
  // {
  //   //オブジェクトの等価で判断したいので、IdentityHashMapを使う。
  //   this.rpsMap = new IdentityHashMap<Object, String>();
  //   this.rpsMap.put(this.mainFrame.getButtonRock(),this.CODE_ROCK);
  //   this.rpsMap.put(this.mainFrame.getButtonScissors(),this.CODE_SCISSORS);
  //   this.rpsMap.put(this.mainFrame.getButtonPaper(),this.CODE_PAPER);
  // }

  /**
   * じゃんけんボタン押下時のアクションリスナー
   */
  @Override
  public void actionPerformed(ActionEvent e){
    //押したボタンからコード値を取得
    String result = this.rpsMap.get(e.getSource());

    //コンピュータの選択をランダムに設定
    Random random = new Random();
    String cpuResult = new String[]{this.CODE_ROCK,this.CODE_SCISSORS,this.CODE_PAPER}[random.nextInt(3)];

    //おあいこ
    if(result.equals(cpuResult)){
      this.mainFrame.setSubTitle("私は" + cpuResult + "。おあいこです。");

    //勝ちパターン
    }else if(this.victoryList.contains(result + ":" + cpuResult)){
      this.mainFrame.setSubTitle("私は" + cpuResult + "。あなたの勝ちです。");

    }else{
      this.mainFrame.setSubTitle("私は" + cpuResult + "。あなたの負けです。");

    }
  }
}
