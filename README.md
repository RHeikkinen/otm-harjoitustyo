<h1>BudgetApp</h1>
Sovelluksen avulla käyttäjä voi pitää kirjaa omista tuloista ja menoistaan, sekä luoda oman henkilökohtaisen budjetin ja seurata sen toteutumista. Sovellus on suppea ja tämänhetkisessä muodossaan käyttökelvoton, sillä sovelluksessa ei esimerkiksi ole mahdollista tallettaa tietoa pysyvästi.

  <h2>Dokumentaatio</h2>

[Vaatimusmäärittely](https://github.com/RHeikkinen/otm-harjoitustyo/blob/master/dokumentaatio/maarittelydokumentti.md)

[Arkkitehtuurikuvaus](https://github.com/RHeikkinen/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)  

[Tuntikirjanpito](https://github.com/RHeikkinen/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)  

## Releaset
[Viikko 5](https://github.com/RHeikkinen/otm-harjoitustyo/releases/tag/vko5)

[Loppupalautus](https://github.com/RHeikkinen/otm-harjoitustyo/releases/tag/v1.0)

## Komentorivitoiminnot
### Projektin koodin suorittamiseen on useampi vaihtoehto:
Jos projekti on ladattuna tietokoneelle, voi sen suorittaa sovelluksen juurikansiossa komennolla:
```
mvn compile exec:java -Dexec.mainClass=budgetapp.domain.Main
```
Toinen vaihtoehto on __suoritettavan jar-tiedoston generoiminen__ target-hakemistoon. Tämä onnistuu komennolla:
```
mvn package
```
Tämän jälkeen ohjelman voi suorittaa juurikansiossa komennolla:
```
java -jar target/BudgetApp-1.0-SNAPSHOT.jar
```
Olettaen, että tiedoston nimeä ei ole muutettu ja se löytyy hakemistosta target.
***
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
***
