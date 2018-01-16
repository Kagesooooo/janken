// package pobj;
import java.util.Random;
import java.util.Scanner;
public class test {

    //じゃんけんのグーチョキパーを定数として宣言
    final int gu = 0;
    final int tyoki = 1;
    final int pa = 2;

    //プレイヤーの出す手は何？
    int play1;
    int play2;

    //出す手をどうやって決めるか？→乱数で判定する
    Random rnd;

    public void player1(){
        rnd = new Random();
        int what = rnd.nextInt(3);

        switch(what){
        case 0:
            this.play1 = gu;
            break;
        case 1:
            this.play1 = tyoki;
            break;
        case 2:
            this.play1 = pa;
            break;
        }
    }

    public void player2(){
        rnd = new Random();
        int what = rnd.nextInt(3);

        switch(what){
        case 0:
            this.play2 = gu;
            break;
        case 1:
            this.play2 = tyoki;
            break;
        case 2:
            this.play2 = pa;
            break;
        }
    }

    public static int janken(int te1, int te2){
      if(te1 == 0 && te2 == 1){
          return 0;
      }else if(te1 == 1 && te2 == 2){
          return 0;
      }else if(te1 == 2 && te2 == 0){
          return 0;
      }else if(te1 == te2){
          //引き分けは何もしない
      }else{
          //それ以外はプレイヤー2の勝ち
          return 1;
      }
      return -1;
    }

    public static void main(String[] args){
        //このクラスのインスタンス
        test obj = new test();
        Scanner scanner = new Scanner(System.in);
        int te1, te2;
        int play1_p = 10;
        int play2_p = 10;

        System.out.println("グー:0, チョキ:1, パー:2\n");

        while(true){
            //プレイヤーを呼び出す
            // obj.player1();
            // obj.player2();

            //試合ごとに結果を表示
            // System.out.println("play1 = "+obj.play1);
            // System.out.println("play2 = "+obj.play2);

            System.out.printf("play1 = ");
            te1 = scanner.nextInt();

            System.out.printf("play2 = ");
            te2 = scanner.nextInt();

            // int j = janken(obj.play1,obj.play2);
            int j = janken(te1, te2);

            if(j==0) {
              play2_p--;
            }
            else if(j==1)
              play1_p--;
            else
              continue;

            System.out.printf("%d %d\n\n",play1_p,play2_p);

            if(play1_p==0||play2_p==0)
              break;
        }

        if(play2_p==0){
            System.out.println("winner player1!!");
        }else{
            System.out.println("winner player2!!");
        }
    }

}
