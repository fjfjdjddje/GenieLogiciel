class A{
    int n=0;
    boolean isFull=true;
    float x=5.3648;


    void setInteger(int x){
        this.n=x;
    }

    void setBoolean(boolean b){
        this.isFull=b;
    }

    void setFloat(float t){
        this.x=t;
    }

    int getInteger(){
        return this.n;
    }
    
    boolean getIsFull(){
        return this.isFull;
    }
    
    float getFloat(){
        return this.x;
    }

}

{   
    A a = new A();
    
    print(a.getFloat());
}
