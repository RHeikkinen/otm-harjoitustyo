package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate kassa;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }

    @Test
    public void luotuKassapaateOnOlemassa() {
        assertTrue(kassa != null);
    }

    @Test
    public void rahamaaraOnOikea() {
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void myytyjenLounaidenMaaraOnOikea() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiOikeinJosMaksuOnRiittava() {
        // JOS MAKSU ON RIITTÄVÄ: 
        // vaihtorahan suuruus on oikea
        assertEquals(120, kassa.syoMaukkaasti(520));
        assertEquals(2, kassa.syoEdullisesti(242));
        // kassassa oleva rahamäärä kasvaa lounaan hinnalla
        assertEquals(100640, kassa.kassassaRahaa());
        // myytyjen lounaiden määrä kasvaa
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiOikeinJosMaksuEiOleRiittava() {
        // JOS MAKSU EI OLE RIITTÄVÄ:
        // kaikki rahat palautetaan vaihtorahana
        assertEquals(350, kassa.syoMaukkaasti(350));
        assertEquals(239, kassa.syoEdullisesti(239));
        // kassassa oleva rahamäärä ei muutu
        assertEquals(100000, kassa.kassassaRahaa());
        // myytyjen lounaiden määrässä ei muutosta
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiostoToimiiOikeinJosKortillaOnTarpeeksiRahaa() {
        Maksukortti kortti = new Maksukortti(1000);
        // JOS KORTILLA ON TARPEEKSI RAHAA: 
        // veloitetaan summa kortilta ja palautetaan true
        assertTrue(kassa.syoMaukkaasti(kortti));
        assertTrue(kassa.syoEdullisesti(kortti));
        assertEquals(360, kortti.saldo());
        // myytyjen lounaiden määrä kasvaa
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        // kassassa oleva rahamäärä ei muutu kortilla ostettaessa
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiostoToimiiOikeinJosKortillaEiOleTarpeeksiRahaa() {
        Maksukortti kortti = new Maksukortti(200);
        // JOS KORTILLA EI OLE TARPEEKSI RAHAA:
        // palautetaan false
        assertFalse(kassa.syoMaukkaasti(kortti));
        assertFalse(kassa.syoEdullisesti(kortti));
        // kortin rahamäärä ei muutu
        assertEquals(200, kortti.saldo());
        // myytyjen lounaiden määrä muuttumaton
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void rahanLataaminenKortilleToimiiOikein() {
        Maksukortti kortti = new Maksukortti(200);
        // kortin saldo muuttuu ja palautetaan true
        assertTrue(kassa.lataaRahaaKortille(kortti, 200));
        assertEquals(400, kortti.saldo());
        // jos ladataan negatiivinen summa:
        // kortin saldo ei muutu ja palautetaan false
        assertFalse(kassa.lataaRahaaKortille(kortti, -200));
        assertEquals(400, kortti.saldo());
        // kassassa oleva rahamäärä kasvaa ladatulla summalla
        assertEquals(100200, kassa.kassassaRahaa());
        
        
    }

}
