import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MainFrame extends JFrame{

  //グーボタン
  private JButton buttonRock;

  //ちょきボタン
  private JButton buttonScissors;

  //パーボタン
  private JButton buttonPaper;

  //サブタイトル
  private JLabel labelSubTitle = new JLabel("どれかボタンを押してね");

  public MainFrame(){
    super("じゃんけんゲーム");

    super.setBounds(200,200,800,300);

    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();

    //JButtonの画像をリサイズするには、ImageIcon作成⇒Imageオブジェクト取り出して再指定⇒ImageIconに再設定とするらしい。。
    ImageIcon imageRock = new ImageIcon("janken_gu.png");
    imageRock.setImage(imageRock.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    this.buttonRock = new JButton(imageRock);

    ImageIcon imageScissors = new ImageIcon("janken_choki.png");
    imageScissors.setImage(imageScissors.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    this.buttonScissors = new JButton(imageScissors);

    ImageIcon imagePaper = new ImageIcon("janken_pa.png");
    imagePaper.setImage(imagePaper.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    this.buttonPaper = new JButton(imagePaper);

    super.add("North",labelSubTitle);

    panel.add(buttonRock);
    panel.add(buttonScissors);
    panel.add(buttonPaper);
    super.add("Center", panel);

    super.setVisible(true);

  }

  /**
   * サブタイトルを設定します。
   * @param subTitle
   */
  public void setSubTitle(String subTitle){
    labelSubTitle.setText(subTitle);
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
