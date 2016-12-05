package perceptron;

public class Perceptron_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double nu[] = {0.35, 0.2};
		Perceptron_lib plib = new Perceptron_lib(2, nu, 0.01, 0.5);

	//�w�K�f�[�^
		double input[][] = { {1,1}, {1,0}, {0,1}, {0,0}};
		double output[] = {1, 0, 0, 0};

	//�w�K
		int index;
		for(int i = 0; i < 150; i++){
			index = (int)(Math.random()*4);  //0~3�̗�������
			plib.getParameter(input[index], output[index]);
			System.out.println("index : "+i+"nu = "+nu[0]+", "+nu[1]);
		}
	
	//���ʊm�F
		for(int i = 0; i < output.length; i++){
			if(plib.getOutput(input[i]) == output[i])
				System.out.println("Correct! : input("+input[i][0]+","+input[i][1]+") to output("+output[i]+")");
				else System.out.println("Miss! : input("+input[i][0]+","+input[i][1]+") to output("+output[i]+")");
		}
		System.out.println("Check : nu = "+nu[0]+", "+nu[1]);
	}
}

//���ʍl�@
//nu[]�ɂ������鏉���l��F�X�ς��Ď��s���Ă݂��Ƃ���
//nu2��0.2�̂܂܂ɂ���nu1��ω���������nu1��0.9�𒴂����Ƃ��납��(1,0)�̕����Ń~�X���N������
//����nu2��0.35�̂܂܂ɂ���nu2��ω��������nu2��0.87�𒴂����Ƃ��납��(0,1)�Ń~�X���N������
//�܂�nu1=nu2�Ƃ��ĕω������Ă݂��0.85�𒴂����Ƃ����ŏI���Ȓl�����ł͂Ȃ��Ȃ�
//���̒l�ɂ���ă~�X���N��������N����Ȃ������肷��悤�ɂȂ����B
//�����̂��Ƃ��珉���l�ɑ傫�Ȓl��^����ƌ��ʂɃ~�X�������邱�Ƃ����������B150�񃋁[�v���Ƃ�������
//0.8~0.9�𒴂���ƃ~�X���N����悤���B