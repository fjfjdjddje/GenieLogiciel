import java.lang.Math;


class ArctanAngle{
	float value;
	ArctanAngle next;
	//Constructeur
	ArctanAngle(float value){
		this.value = value;
		this.next = null;
	}
	ArctanAngle head = null;
	ArctanAngle tail = null;

	public void addAtEnd(float value){
		ArctanAngle angle = new ArctanAngle(value);
		angle.next = null;
		if(head == null){
			head = angle;
			tail = angle;
		}
		else{
			tail.next = angle;
			tail = angle;
		}
	}

	public float getAngleStep(int i){
		ArctanAngle angle = head;
		int step = 0;
		while(angle != null){
			if(step == i){
				return(angle.value);
			}
			step = step + 1;
			angle = angle.next;
		}
		return 0;
	}

}

class CircularVector{
	float cos;
	float sin;
	float tan;
	CircularVector(float cos, float sin, float tan){
		this.cos = cos;
		this.sin = sin;
		this.tan = tan;
	}
}

public class MathCordic{
	final static float pi = 3.141592653589f;  // 12 chiffres
	final static int n = 50;
	//int k = 6072529350088;
	final static float lowestEver = 1/twoPower(149);
	final static float biggestEver = twoPower(32);
	

	public static ArctanAngle createAngleTable(){
		ArctanAngle anglesTable = new ArctanAngle(0);
		anglesTable.addAtEnd(0.7853981633974483f);
		anglesTable.addAtEnd(0.46364760900080615f);
		anglesTable.addAtEnd(0.24497866312686414f);
		anglesTable.addAtEnd(0.12435499454676144f);
		anglesTable.addAtEnd(0.06241880999595735f);
		anglesTable.addAtEnd(0.031239833430268277f);
		anglesTable.addAtEnd(0.015623728620476831f);
		anglesTable.addAtEnd(0.007812341060101111f);
		anglesTable.addAtEnd(0.0039062301319669718f);
		anglesTable.addAtEnd(0.0019531225164788188f);
		anglesTable.addAtEnd(0.0009765621895593195f);
		anglesTable.addAtEnd(0.0004882812111948983f);
		anglesTable.addAtEnd(0.00024414062014936177f);
		anglesTable.addAtEnd(0.00012207031189367021f);
		anglesTable.addAtEnd(6.103515617420877e-05f);
		anglesTable.addAtEnd(3.0517578115526096e-05f);
		anglesTable.addAtEnd(1.5258789061315762e-05f);
		anglesTable.addAtEnd(7.62939453110197e-06f);
		anglesTable.addAtEnd(3.814697265606496e-06f); 
		anglesTable.addAtEnd(1.907348632810187e-06f);
		anglesTable.addAtEnd(9.536743164059608e-07f);
		anglesTable.addAtEnd(4.7683715820308884e-07f);
		anglesTable.addAtEnd(2.3841857910155797e-07f);
		anglesTable.addAtEnd(1.1920928955078068e-07f);
		anglesTable.addAtEnd(5.960464477539055e-08f);
		anglesTable.addAtEnd(2.9802322387695303e-08f);
		anglesTable.addAtEnd(1.4901161193847655e-08f);
		anglesTable.addAtEnd(7.450580596923828e-09f);
		anglesTable.addAtEnd(3.725290298461914e-09f);
		anglesTable.addAtEnd(1.862645149230957e-09f);
		return anglesTable;
	}
	final static ArctanAngle anglesTable = createAngleTable();

	public static float twoPower(int i){
		if(i == 0){
			return 1;
		}
		else{
			float result = 1;
			int k = 1;
			while(k <= i){
				result = 2*result;
				k = k + 1;
			}
			return result;
		}
	}
	

//    public static void rotateClockWise();
//    public static void rotateCounterClockWise();

	public static float absolute(float f){
		if(f >= 0){
			return(f);
		}
		else{
			return(-f);
		}
	}

	
float ulp(float f){
		int relatifToAbsolute = 0;
		int reverseRelatifToAbsolute;
		int absolutePower = 24;
		f = absolute(f);
		if(f == 0){
			return lowestEver;
		}
		if(f < lowestEver){
			return lowestEver;
		}
		if(f > biggestEver){
			return biggestEver;
		}
		if((f <= twoPower(absolutePower - 1) && f < byTwoPower(1 - absolutePower)) || (f >= twoPower(absolutePower) && f >= byTwoPower(-absolutePower))){
			while(f < twoPower(absolutePower - 1) && (f < byTwoPower(1 - absolutePower))){
				absolutePower = absolutePower - 1;
				relatifToAbsolute = relatifToAbsolute - 1;
			}
			if(relatifToAbsolute >= 0){
				return(twoPower(relatifToAbsolute));

			}
			else{
				return(byTwoPower(relatifToAbsolute));
			}
		}
		else if(f >= twoPower(absolutePower)){
			while(f >= twoPower(absolutePower) && f >= byTwoPower(-absolutePower)){
			absolutePower = absolutePower + 1;
			relatifToAbsolute = relatifToAbsolute + 1;
			}
			if(relatifToAbsolute >= 0){
				return(twoPower(relatifToAbsolute));

			}
			else{
				reverseRelatifToAbsolute = -relatifToAbsolute;
				return(byTwoPower(reverseRelatifToAbsolute));
			}			
		}
		else{
			if(relatifToAbsolute >= 0){
				return(twoPower(relatifToAbsolute));

			}
			else{
				reverseRelatifToAbsolute = -relatifToAbsolute;
				return(byTwoPower(reverseRelatifToAbsolute));
			}
		}
	}
	

	public static CircularVector cordicDirect(float theta){
		float x = 0.6072529350088f;
		float y = 0;
		float xi, yi, zi;
		float testPeriodique = -1;
		float angleStep;
		while(theta < -pi || theta > pi){
			if(theta < -pi){
				theta = theta + 2*pi;
			}
			if(theta > pi){
				theta = theta - 2*pi;
			}
		}
		if(theta < -pi/2){
			theta = theta + pi;
		}
		else if(theta > pi/2){
			theta = theta - pi;
		}
		else{
			testPeriodique = 1;
		}
		float z = theta;
		int i = 0;
		while(i <= n){
			if(i <= 29){
				angleStep = anglesTable.getAngleStep(i);
			}
			else{
				angleStep = 1/twoPower(i);
			}
			if(z >= 0){
				xi = x - y/twoPower(i);
				yi = y + x/twoPower(i);
				zi = z - angleStep;
			}
			else{
				xi = x + y/twoPower(i);
				yi = y - x/twoPower(i);
				zi = z + angleStep;
			}
			x = xi;
			y = yi;
			z = zi;
			i = i + 1;
		}
		CircularVector trigoVector = new CircularVector(testPeriodique*x, testPeriodique*y, y/x);
		return trigoVector;
	}

	public static float cos(float theta){
		CircularVector trigoVector = cordicDirect(theta);
		return trigoVector.cos;
	}

	public static float sin(float theta){
		CircularVector trigoVector = cordicDirect(theta);
		return trigoVector.sin;
	}

	public static float tan(float theta){
		CircularVector trigoVector = cordicDirect(theta);
		return trigoVector.tan;
	}

	public static float arccos(float t){
		if(t < -1 || t > 1){
			throw new IllegalArgumentException("entre -1 et 1");
		}
		float x = 1;
		float y = 0;
		float z = t;
		float xi, yi, ki, angleStep;
		float theta = 0;
		int i = 0;
		while(i <= n){
			if(i <= 32){
				angleStep = anglesTable.getAngleStep(i);
			}
			else{
				angleStep = 1/twoPower(i);
			}
			ki = 1 + 1/twoPower(2*i);
			if((y >= 0 && z <= x) || (y < 0 && z > x)){
				xi = x - y/twoPower(i);
				yi = y + x/twoPower(i);
				x = xi - yi/twoPower(i);
				y = yi + xi/twoPower(i);
				theta  = theta + 2*angleStep;
			}
			else{
				xi = x + y/twoPower(i);
				yi = y - x/twoPower(i);
				x = xi + yi/twoPower(i);
				y = yi - xi/twoPower(i);
				theta  = theta - 2*angleStep;
			}
			z = ki*z;
			i = i + 1;
		}
		return theta;
	}

	public static float arcsin(float t){
		if(t < -1 || t > 1){
			throw new IllegalArgumentException("entre -1 et 1");
		}
		float x = 1;
		float y = 0;
		float z = t;
		float xi, yi, ki, angleStep;
		float theta = 0;
		int i = 0;
		while(i <= n){
			if(i <= 32){
				angleStep = anglesTable.getAngleStep(i);
			}
			else{
				angleStep = 1/twoPower(i);
			}
			ki = 1 + 1/twoPower(2*i);
			if((x < 0 && y <= z) || (x >= 0 && z < y)){
				xi = x + y/twoPower(i);
				yi = y - x/twoPower(i);
				x = xi + yi/twoPower(i);
				y = yi - xi/twoPower(i);
				theta  = theta - 2*angleStep;
			}
			else{
				xi = x - y/twoPower(i);
				yi = y + x/twoPower(i);
				x = xi - yi/twoPower(i);
				y = yi + xi/twoPower(i);
				theta  = theta + 2*angleStep;
			}
			z = ki*z;     // pour la limite
			i = i + 1;
		}
		return theta;
	}

	public static float arctan(float t){
		float x = 1; 
		float y, xi, yi, angleStep;
		float sign;
		float testParite = 1;
		float theta = 0;
		int i = 0;
		if(t < 0){
			testParite = -1;
		}
		y = testParite*t;
		while(i <= n){
			if(i <= 32){
				angleStep = anglesTable.getAngleStep(i);
			}
			else{
				angleStep = 1/twoPower(i);
			}
			if(y > 0){
				xi = x + y/twoPower(i);
				yi = y - x/twoPower(i);
				theta = theta + anglesTable.getAngleStep(i);
				x = xi;
				y = yi;
				System.out.println(x + " h " + y);
				System.out.println(theta);
			}
			else{
				xi = x - y/twoPower(i);
				yi = y + x/twoPower(i);
				theta = theta - anglesTable.getAngleStep(i);
				x = xi;
				y = yi;
				System.out.println(x + " h " + y);
				System.out.println(theta);


			}
			i = i + 1;
		}
		return testParite*theta;
	}

	public static void main(String[] args){
		//System.out.println(ulp(1/twoPower(23)));
		System.out.println(arctan(0.5f));
		System.out.println("cos(90) = " + cos(pi/2) + " whilst it should be " + java.lang.Math.cos(pi/2));
		System.out.println("cos(120) = " + cos(120*pi/180) + " whilst it should be " + java.lang.Math.cos(120*pi/180));
		System.out.println("cos(210) = " + cos(210*pi/180) + " whilst it should be " + java.lang.Math.cos(210*pi/180));
		System.out.println("cos(300) = " + cos(300*pi/180) + " whilst it should be " + java.lang.Math.cos(300*pi/180));
		System.out.println("cos(-60) = " + cos(-60*pi/180) + " whilst it should be " + java.lang.Math.cos(-60*pi/180));
		System.out.println("cos(-120) = " + cos(-120*pi/180) + " whilst it should be " + java.lang.Math.cos(-120*pi/180));
		System.out.println("cos(-210) = " + cos(-210*pi/180) + " whilst it should be " + java.lang.Math.cos(-210*pi/180));
		System.out.println("cos(-300) = " + cos(-300*pi/180) + " whilst it should be " + java.lang.Math.cos(-300*pi/180));
		System.out.println("sin(60) = " + sin(60*pi/180) + " whilst it should be " + java.lang.Math.sin(60*pi/180));
		System.out.println("sin(120) = " + sin(120*pi/180) + " whilst it should be " + java.lang.Math.sin(120*pi/180));
		System.out.println("sin(210) = " + sin(210*pi/180) + " whilst it should be " + java.lang.Math.sin(210*pi/180));
		System.out.println("sin(300) = " + sin(300*pi/180) + " whilst it should be " + java.lang.Math.sin(300*pi/180));
		System.out.println("sin(-60) = " + sin(-60*pi/180) + " whilst it should be " + java.lang.Math.sin(-60*pi/180));
		System.out.println("sin(-120) = " + sin(-120*pi/180) + " whilst it should be " +java.lang.Math.sin(-120*pi/180));
		System.out.println("sin(-210) = " + sin(-210*pi/180) + " whilst it should be " + java.lang.Math.sin(-210*pi/180));
		System.out.println("sin(-300) = " + sin(-300*pi/180) + " whilst it should be " + java.lang.Math.sin(-300*pi/180));
	}
}
