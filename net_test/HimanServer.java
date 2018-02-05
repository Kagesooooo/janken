//  練習問題 肥満度判定サーバ
// package net;
import java.net.*;
import java.io.*;
import java.util.*;

public class HimanServer {
   public static void main(String[] args) throws IOException {
      ServerSocket serverS = null;
      Socket clientS = null;
      Socket clientS1 = null;
      try{
          serverS = new ServerSocket(50001);
      } catch (IOException e) {
          System.out.println("ポートにアクセスできません。");
          System.exit(1);
      }

      try{
         clientS = serverS.accept();
      } catch (IOException e) {
         System.out.println("Acceptに失敗しました。");
         System.exit(1);
      }

      // try{
      //    clientS1 = serverS.accept();
      // } catch (IOException e) {
      //    System.out.println("Acceptに失敗しました。");
      //    System.exit(1);
      // }

      PrintWriter out = new PrintWriter(clientS.getOutputStream(), true);
      // PrintWriter out1 = new PrintWriter(clientS1.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(clientS.getInputStream()));

      String fromS, fromU, fromS1;
      // HimandoHantei calc = new HimandoHantei();
      //
      // out1.println("肥満度を判定します。");
      // out.println("肥満度判定サーバ: あなたの体重(Kg)を入力してください。");
      // fromU = in.readLine();  //クライアントが入力した体重を読む
      //
      // try{
      //    calc.w = Double.parseDouble(fromU);  //体重を設定
      // } catch (NumberFormatException error){ calc.w = 0.0;}
      //
      // out.println("肥満度判定サーバ: あなたの身長(cm)を入力してください。");
      // fromU = in.readLine();  //クライアントが入力した身長を読む
      // try{
      //    calc.h = Double.parseDouble(fromU);  //身長を設定
      // } catch (NumberFormatException error){ calc.h = 0.0;}
      //
      // fromS = "肥満度判定サーバ: あなたの標準体重は" + calc.calcStdWeight() + "Kg。" + "肥満度は" + calc.judgeHiman() + "です。";
      // out.println(fromS);     //判定をクライアントに渡す

      Scanner scanner = new Scanner(System.in);
      int te1, te2; //出した手 0:グー, 1:チョキ, 2:パー
      int sen; //宣言した手 0:グー, 1:チョキ, 2:パー
      int play1_p = 10, play2_p = 10; //持ち点
      boolean flag = true; //攻めが1ならtrue, 2ならfalse

      out.println("グー:0 チョキ:1 パー:2");
      // out1.println("グー:0 チョキ:1 パー:2");

      // while(true) {
        if(flag) {
          out.println("play1の宣言");
        }
        else {
          out.println("play2の宣言");
        }
        // sen = scanner.nextInt();
        fromU = in.readLine();

        out.println("play1 = ");
        te1 = scanner.nextInt();
        te1 = Integer.parseInt(in.readLine());

        out.println("play2 = ");
        te2 = scanner.nextInt();
        te2 = Integer.parseInt(in.readLine());



        // int j = janken(te1, te2);
      //   if(j==0) {
      //     if(flag) {
      //       play2_p--;
      //       if(sen==te1)
      //         play2_p--;
      //     }
      //   }
      //   else if(j==1) {
      //     if(!flag) {
      //       play1_p--;
      //       if(sen==te2)
      //         play1_p--;
      //     }
      //   }
      //   else if(j==-1)
      //     continue;
      //   System.out.printf("%d %d\n\n",play1_p,play2_p);
      //   if(play1_p==0||play2_p==0)
      //     break;
      //   flag = !flag;
      // }


      in.close();
      out.close();
      clientS.close();
      serverS.close();
    }
}


// class HimandoHantei{
//    double w, h; //体重と身長
//    double calcStdWeight(){ //標準体重を計算
//       return h/100 * h/100 * 22;
//    }
//
//    double calcHimando(){  //肥満度を計算
//       return w /((h/100)*(h/100));
//    }
//
//    String judgeHiman(){  //肥満度を判定
//       double him = calcHimando();
//       if (him<=15) return "痩せすぎ";
//       else if (him>15 && him<=20) return "痩せぎみ";
//       else if (him>20 && him<=25) return "普通";
//       else if (him>25 && him<=30) return "太りぎみ";
//       else return "太りすぎ";
//    }
// }
