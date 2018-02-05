import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


// @SuppressWarnings("serial")
public class MainFrame extends JFrame{

  //グーボタン
  private JButton buttonRock;

  //ちょきボタン
  private JButton buttonScissors;

  //パーボタン
  private JButton buttonPaper;

  //サブタイトル
  private JLabel labelSubTitle = new JLabel("どれかボタンを押してね");
  private JLabel pointLabel = new JLabel("ポイント！！！");

  public MainFrame(){
    super("じゃんけんゲーム");

    super.setBounds(200,200,800,300);

    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();

    //JButtonの画像をリサイズするには、ImageIcon作成⇒Imageオブジェクト取り出して再指定⇒ImageIconに再設定とするらしい。。
    ImageIcon imageRock = new ImageIcon("janken_gu.png");
    imageRock.setImage(imageRock.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    this.buttonRock = new JButton(imageRock);
    this.buttonRock.setBorderPainted(false);

    ImageIcon imageScissors = new ImageIcon("janken_choki.png");
    imageScissors.setImage(imageScissors.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    this.buttonScissors = new JButton(imageScissors);
    this.buttonScissors.setBorderPainted(false);

    ImageIcon imagePaper = new ImageIcon("janken_pa.png");
    imagePaper.setImage(imagePaper.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    this.buttonPaper = new JButton(imagePaper);
    this.buttonPaper.setBorderPainted(false);

    super.add("North",labelSubTitle);
    super.add("South",pointLabel);

    panel.add(buttonRock);
    panel.add(buttonScissors);
    panel.add(buttonPaper);
    super.add("Center", panel);

    super.setVisible(true);

  }

  /**
   * サブタイトルを設定します。
   * @/param subTitle
   */
  public void setSubTitle(String subTitle){
    labelSubTitle.setText(subTitle);
  }

  public void setPointLabel(int play1_p, int play2_p){
    pointLabel.setText("play1:"+String.valueOf(play1_p)+"play2:"+String.valueOf(play2_p));
  }

  public JButton getButtonRock() {
    return buttonRock;
  }

  public JButton getButtonScissors() {
    return buttonScissors;
  }

  public JButton getButtonPaper() {
    return buttonPaper;
  }



}
