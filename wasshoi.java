public class wasshoi{
  // Scanner scanner = new Scanner(System.in);
  int te1, te2; //出した手 0:グー, 1:チョキ, 2:パー
  int sen; //宣言した手 0:グー, 1:チョキ, 2:パー
  int play1_p = 10, play2_p = 10; //持ち点
  boolean flag = true; //攻めが1ならtrue, 2ならfalse

  public int getTe1() {
    return te1;
  }

  public static int janken(int te1, int te2){
    if(te1 == 0 && te2 == 1){
        return 0;
    }else if(te1 == 1 && te2 == 2){
        return 0;
    }else if(te1 == 2 && te2 == 0){
        return 0;
    }else if(te1 == te2){
        return -1;
    }else{
          //それ以外はプレイヤー2の勝ち
        return 1;
    }
  }
}
