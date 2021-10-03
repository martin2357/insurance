Zadanie:

Vytvor program pomocou Springu, ktorý bude vedieť príjmať, ukladať do databázy, zobrazovať zvolené údaje o poistencovi a jeho zmluvách. U každého poistenca by mal systém evidovať identifikátor, zoznam zmlúv, trvalú  a korešpondenčnú adresu. 
Systém eviduje dva typy zmlúv Poistenie majetku a Cestovné poistenie. 

Systém publikuje nasledovné REST webové služby:

- GET zoznam poistencov v abecednom poradí 
- POST zaevidovanie nového poistenca
- GET detail poistenca na základe zadaného Id.


Program dokáže:

- zobraziť zoznam poistencov v abecednom poradí na url: (/insured), 
- pridá nového poistenca do databázy H2 a pri úspešnom pokuse vráti jeho nové Id, ktoré je    generované automaticky. 
-zobrazí na adrese insured/{id poistenca} detail poistenca – všetky jeho údaje, zmluvy.

Špecifiká programu:

Program je tvorený v jazyku Java pomocou frameworku Spring. Používam dependency (lombok, Spring Web, JPA, H2), program je postavený na REST architektúre, spracováva API, ktoré sú v JSON formáte. Program pracuje na troch úrovniach (Controller, Service, Repository + DB).
