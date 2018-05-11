<h1>BudgetApp</h1>

  <h2>Dokumentaatio</h2>

[Vaatimusmäärittely](https://github.com/RHeikkinen/otm-harjoitustyo/blob/master/dokumentaatio/maarittelydokumentti.md)

[Arkkitehtuurikuvaus](https://github.com/RHeikkinen/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)  

[Tuntikirjanpito](https://github.com/RHeikkinen/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)  

## Julkaisut (releases)
[Viikko 5](https://github.com/RHeikkinen/otm-harjoitustyo/releases/tag/vko5)

## Komentorivitoiminnot
Projektin koodin suorittaminen onnistuu komennolla:
```
mvn compile exec:java -Dexec.mainClass=budgetapp.domain.Main
```
### Testit ja testauskattavuus
Testien suorittaminen ja jacoco-testauskattavuus onnistuvat komennolla:
```
mvn test jacoco:report
```
Kattavuusraportin saa näkyviin avaamalla selaimella tiedoston target/site/jacoco/index.html
### Checkstyle
Checkstylen voi suorittaa komennolla:
```
mvn jxr:jxr checkstyle:checkstyle
```
Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedoston target/site/checkstyle.html
### Suoritettavan jar-tiedoston luominen
Hakemistoon target on mahdollista luoda suoritettava jar-tiedosto _BudgetApp-1.0-SNAPSHOT.jar_ komennolla:
```
mvn package
```
Tämän jälkeen ohjelman voi suorittaa ohjelman juurikansiossa komennolla
```
java -jar target/BudgetApp-1.0-SNAPSHOT.jar
```
***
