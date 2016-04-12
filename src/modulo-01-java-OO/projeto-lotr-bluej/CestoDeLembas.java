public class CestoDeLembas
{
    private int x;
    public CestoDeLembas(int x)
    {
        this.x = x;
    }
    
    public boolean podeDividirEmPares(){
        if(x%2==0 && x>2 && x<=100){
            return true;
        }
        return false;        
    }
   
}
    