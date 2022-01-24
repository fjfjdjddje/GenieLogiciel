class A{
    int a=5;
    
    void setA(int x){
        this.a=x;
    }

    int getA(){
        return this.a;
    }


}

class B{
    int b = 7;
}

class A1 extends A{
    int a1=1;

    void setApre(int x){
        this.a1=x;
    }

    int getApre(){
        return this.a1;
    }


}

class A2 extends A{
    int a2=2;

    void setAsec(int x){
        this.a2=x;
    }

    int getAsec(){
        return this.a2;
    }


}

class A3 extends A{
    int a3=3;

    void setAthr(int x){
        this.a3=x;
    }

    int getA(){
        return this.a3;
    }

}


{   

    //Test de instance of pour l'heritage multiple
    A x = new A();
    A1 x1 = new A1();
    A2 x2 = new A2();
    A3 x3 = new A3();
    B y = new B();
    int a = x.getA();
    println("true ==", x1 instanceof A1);
    println("true ==", x1 instanceof Object );
    println("true ==", x2 instanceof A2 );
    println("true ==", x1 instanceof A );
    println("true ==", x3 instanceof A );
    println("false == ", y instanceof A );

    //Verification de l'override des environnement et l'accès aux environnements parents

   
    if(a==5){
        println("C'est juste");
    }else{
        println("C'est faux");
    }
    
    a=x1.getApre();
    if(a==1){
        println("C'est juste");
    }else{
        println("C'est faux");
    }

    a=x1.getA();
    if(a==5){
        println("C'est juste");
    }else{
        println("C'est faux");
    }

    a=x3.getA();
    if(a==2){
        println("C'est juste");
    }else{
        println("C'est faux");
    }

    a=x3.getA();
    if(a==5){
        println("C'est juste");
    }else{
        println("C'est faux");
    }


}
