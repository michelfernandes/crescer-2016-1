import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SindarinParaPortuguesTest
{
    @Test
    public void traduzirNaurParaPortugues(){
        //naur
        TradutorSindarin tradutorPortugues = new SindarinParaPortugues();
        assertEquals("fogo",tradutorPortugues.traduzir("naur"));
        assertEquals("vento",tradutorPortugues.traduzir("gwaew"));
        assertEquals("terra",tradutorPortugues.traduzir("amar"));
        assertEquals("coração",tradutorPortugues.traduzir("gûr"));
        assertEquals("água",tradutorPortugues.traduzir("nen"));
    }
    @Test
    public void traduzirNullParaPortugues() {
        TradutorSindarin tradutorPortugues = new SindarinParaPortugues();
        assertNull(tradutorPortugues.traduzir(null));
    }
}