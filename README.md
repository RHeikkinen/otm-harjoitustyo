<h1>BudgetApp (OTM harjoitustyö kevät 2018)</h1>

  <h2>Dokumentaatio</h2>

[Vaatimusmäärittely](https://github.com/RHeikkinen/otm-harjoitustyo/blob/master/dokumentaatio/maarittelydokumentti.md)  
[Alustava luokkakaavio](https://github.com/RHeikkinen/otm-harjoitustyo/blob/master/dokumentaatio/BudgetAppUML.png)  
[Tuntikirjanpito](https://github.com/RHeikkinen/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)  

## Komentorivitoiminnot
Projektin koodin suorittaminen onnistuu komennolla
```
mvn compile exec:java -Dexec.mainClass=budgetapp.domain.Main
```
### Testit ja testauskattavuus
Testien suorittaminen ja jacoco-testauskattavuus onnistuvat komennolla
```
mvn test jacoco:report
```
### Checkstyle
Voit suorittaa Checkstylen komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
### Suoritettavan jar-tiedoston luominen
komento
```
mvn package
```
luo hakemistoon target suoritettavan jar-tiedoston _BudgetApp-1.0-SNAPSHOT.jar_ 
***
