class A{
    int x;
    int  y;


    void setX(int x){
        this.x=x;
    }
    
    void setY(int x){
        this.y=x;
    }

    int getX(){
        return this.x;
    }

    int getY(){
        return this.y;
    }

    int coordVect(){
        return this.y-this.x;
    }

    boolean equals(A a){
        return (this.x == a.x) && (this.y == a.y) ;
    }

    boolean match(int a, int b){
        return a==this.x && b==this.y;
    }

}
{
    A a1 = new A();
    A a2 = new A();
    a1.setX(2);
    a2.setX(2);
    a1.setY(4);
    a2.setY(4);

    //Verification de la methode Equals

    //b1 est true ;
    boolean b1 = a1.equals(a1);
    print("true ==",b1);
    //b2 est true ;
    boolean b2 = a2.equals(a1);
    print("true ==",b2);

    A a3 = new A();
    a3.setX(5);
    a3.setY(7);
    //b3 est false ;
    boolean b3 = a1.equals(a3);
    print("false ==",b3);

    a3.setX(a1.getX());
    a3.setY(a1.getY());
    b3 = a1.equals(a3);
    print("true ==",b3);

    //verification de la methode CoordVect

    int c1 = a1.coordVect();
    print("2==",c1);
    

}