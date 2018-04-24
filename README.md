<h1>OTM harjoitustyö (kevät 2018)</h1>

<h2>BudgetApp</h2>

  <h3>Dokumentaatio</h3>

[Vaatimusmäärittely](https://github.com/RHeikkinen/otm-harjoitustyo/blob/master/dokumentaatio/maarittelydokumentti.md)  
[Alustava luokkakaavio](https://github.com/RHeikkinen/otm-harjoitustyo/blob/master/dokumentaatio/BudgetAppUML.png)  
[Tuntikirjanpito](https://github.com/RHeikkinen/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)  

### Komentorivitoiminnot
Projektin koodin suorittaminen onnistuu komennolla
```
mvn compile exec:java -Dexec.mainClass=budgetapp.domain.Main
```
Testien suorittaminen ja jacoco-testauskattavuus onnistuvat komennolla
```
mvn test jacoco:report
```
Voit suorittaa Checkstylen komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
***
