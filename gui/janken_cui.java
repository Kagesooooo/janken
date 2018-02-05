import java.util.Scanner;
public class janken_cui {
  public static int janken(int te1, int te2){
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

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int te1, te2; //出した手 0:グー, 1:チョキ, 2:パー
    int sen; //宣言した手 0:グー, 1:チョキ, 2:パー
    int play1_p = 10, play2_p = 10; //持ち点
    boolean flag = true; //攻めが1ならtrue, 2ならfalse

    System.out.println("グー:0, チョキ:1, パー:2\n");

    while(true){
      if(flag) {
        System.out.printf("play1の宣言 = ");
      }
      else {
        System.out.printf("play2の宣言 = ");
      }
      sen = scanner.nextInt();

      System.out.printf("play1 = ");
      te1 = scanner.nextInt();
      System.out.printf("play2 = ");
      te2 = scanner.nextInt();
      int j = janken(te1, te2);
      if(j==0) {
        if(flag) {
          play2_p--;
          if(sen==te1)
            play2_p--;
        }
      }
      else if(j==1) {
        if(!flag) {
          play1_p--;
          if(sen==te2)
            play1_p--;
        }
      }
      else if(j==-1)
        continue;
      System.out.printf("%d %d\n\n",play1_p,play2_p);
      if(play1_p==0||play2_p==0)
        break;
      flag = !flag;
    }

    if(play2_p==0){
      System.out.println("winner player1!!");
    }else{
      System.out.println("winner player2!!");
    }
  }
}
