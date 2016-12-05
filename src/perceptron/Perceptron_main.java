package perceptron;

public class Perceptron_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double nu[] = {0.35, 0.2};
		Perceptron_lib plib = new Perceptron_lib(2, nu, 0.01, 0.5);

	//学習データ
		double input[][] = { {1,1}, {1,0}, {0,1}, {0,0}};
		double output[] = {1, 0, 0, 0};

	//学習
		int index;
		for(int i = 0; i < 150; i++){
			index = (int)(Math.random()*4);  //0~3の乱数発生
			plib.getParameter(input[index], output[index]);
			System.out.println("index : "+i+"nu = "+nu[0]+", "+nu[1]);
		}
	
	//結果確認
		for(int i = 0; i < output.length; i++){
			if(plib.getOutput(input[i]) == output[i])
				System.out.println("Correct! : input("+input[i][0]+","+input[i][1]+") to output("+output[i]+")");
				else System.out.println("Miss! : input("+input[i][0]+","+input[i][1]+") to output("+output[i]+")");
		}
		System.out.println("Check : nu = "+nu[0]+", "+nu[1]);
	}
}

//結果考察
//nu[]にあたえる初期値を色々変えて実行してみたところ
//nu2は0.2のままにしてnu1を変化させたらnu1が0.9を超えたところから(1,0)の部分でミスが起こった
//次はnu2を0.35のままにしてnu2を変化させるとnu2が0.87を超えたところから(0,1)でミスが起こった
//またnu1=nu2として変化させてみると0.85を超えたところら最終亭な値が一定ではなくなり
//その値によってミスが起こったり起こらなかったりするようになった。
//これらのことから初期値に大きな値を与えると結果にミスが生じることが分かった。150回ループだとだいたい
//0.8~0.9を超えるとミスが起きるようだ。