import java.util.Scanner;
public class unko_cui {
  // public static int janken(int te1, int te2){
  //   if(te1 == 0 && te2 == 1){
  //       return 0;
  //   }else if(te1 == 1 && te2 == 2){
  //       return 0;
  //   }else if(te1 == 2 && te2 == 0){
  //       return 0;
  //   }else if(te1 == te2){
  //       return -1;
  //   }else{
  //         //それ以外はプレイヤー2の勝ち
  //       return 1;
  //   }
  // }

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    // int te1, te2; //出した手 0:グー, 1:チョキ, 2:パー
    // int sen; //宣言した手 0:グー, 1:チョキ, 2:パー
    // int play1_p = 10, play2_p = 10; //持ち点
    // boolean flag = true; //攻めが1ならtrue, 2ならfalse

    System.out.println("グー:0, チョキ:1, パー:2\n");

    wasshoi  unko = new wasshoi();

    while(true){
      if(unko.flag) {
        System.out.printf("play1の宣言 = ");
      }
      else {
        System.out.printf("play2の宣言 = ");
      }
      sen = scanner.nextInt();

      System.out.printf("play1 = ");
      unko.te1 = scanner.nextInt();
      System.out.printf("play2 = ");
      unko.te2 = scanner.nextInt();
      int j = unko.janken(unko.te1, unko.te2);
      if(j==0) {
        if(unko.flag) {
          unko.play2_p--;
          if(sen==unko.te1)
            unko.play2_p--;
        }
      }
      else if(j==1) {
        if(!unko.flag) {
          unko.play1_p--;
          if(sen==unko.te2)
            unko.play1_p--;
        }
      }
      else if(j==-1)
        continue;
      System.out.printf("%d %d\n\n",unko.play1_p,unko.play2_p);
      if(unko.play1_p==0||unko.play2_p==0)
        break;
      unko.flag = !unko.flag;
    }

    if(unko.play2_p==0){
      System.out.println("winner player1!!");
    }else{
      System.out.println("winner player2!!");
    }
  }
}
