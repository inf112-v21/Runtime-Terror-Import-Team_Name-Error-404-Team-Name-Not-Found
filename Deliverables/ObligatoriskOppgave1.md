# Gruppe 8 - Runtime Terror Import Team_Name Error 404 Team Name Not Found 

## Oppgave 1


Vi har valg teamnavnet **Runtime Terror Import Team_Name Error 404 Team Name Not Found**.

Belmin:
Er 2. semester student på datasikkerhet, hadde `INF100` i fjor, og tar `INF112` ved siden av INF101 nå. Er relativ ny til Java programering, men har brukt Python en liten del. 

Martin er 6. semesters student på IMØ med fagene `INF100-102`, `INF140` og `INF142`. Har ikke programmert så mye i det siste så er litt rusten. Er interresert i nettverk og datamaskinarkitektur system utvikling. 


Thomas har studert 1,5 år i Tromsø. Her har han fulført fag som "Inføring i programering", "Objekt orientert programering" og "Datastrukturer og algoritmer". I Bergen er han på sit andre semester og har fulført fag som `INF122` og `INF140`.

Odin
2 Semester student på datasikkerhet, ferdig med `Inf100` og holder på med `Inf101`. Har gått år tidligere på HVL hvor jeg var borti java programering. Tidligere erfaring fra IT 1 og IT 2 fra vgs. Også litt erfaring fra FHS teknologi linje. 



Kim Andre
4 semester på bachelor data vitenskap. har hatt fagene `INF100`, `INF101`, `INF102`, `INF122`, `MNF130`, og diverse matte fag. har erfaringer i java fra `INF101` og `INF102`


Alle i teamet har på noe erfaring med programmering. Alle har vært borti java før og noen har mer erfaring en andre.

### Roller
[Martin](https://github.com/mrtineide) tar rolle som teamleder fordi han har erfaring som leder.
- Leder teammøter
- Holder orden/ryddig/systematisk project board
- Har ansvar for at kodekvalitet og merge inn i master branch
- Ha ansvar for at folk gjør sine oppgaver
- Har ansvar for at folk har noe å gjøre

[Thomas](https://github.com/TheLimeFreak) er LIBgdx utvikler.
- Ansvar for det visuelle foran brukeren
- Har ansvar for å sette seg inn i og kunne LIBgdx

[Kim](https://github.com/KimAndreG) har rollen som testleder. 
- Har ansvar for at vi følger testdreven metodikk. 
- Sørger for at vi har god testdekning på logikken

[Belmin](https://github.com/BelminH) har rollen som sekretær.
- Har ansvar for møtereferater og den skriftlige delen av oppgavene.

[Odin](https://github.com/OdinBjerga) tar rolle som kundekontakt (i den grad vi har en kunde).
- Har ansvar for at vi følger spesifikasjonene og krav fra oppgavene. 
- Har ansvar for at å sette seg inn i og kunne spesifikasjonene og kravene fra oppgavene.

## Oppgave 2

- [x] Bestemme oss for en prosjektmetodikk/hvilke elemter fra de vi skal bruke (kanban)
- [x] Diskutere hvilke metoder som hjelper teamet med å utvikle fungerende og veldokumentert programvare. Få med tilpasningene som må med for at det skal fungere på studentprosjektet.
    - [x] Hvilke språk skal vi bruke?
- [x] Vurder viktig aspeketer ved prossesen
    - [ ] Hvordan oranisere møter
    - [x] Definisjon og tildeling av oppgaver
    - [ ] Hvilke utviklingsaktiviteter som trengs (og når) som parporgrammering osv.
- [ ] Skriv en kort beskrivelse av hvordan teamet planlegger å organisere prosjektet den første tiden. 


- Lage kommentarer som forklarer forvirrende kode
- Skiver kildekode og kommentarer i kildekode på engelsk, ellers så bruker man det som gjør en forstått.
- Skriver tester

- faste tider/punkter
- Aktiviserer seg selv
### Hvordan holde god kodekvalitet og dokumentasjon (diskusjon)
Ved å bruke testdrevet metodikk så har vi en metode som tvinger oss til å tenke gjennom hva vi trenger å gjøre.
Når vi alle sammen er enig og snakket sammen om hvilke forventninger og regler vi skal ha for prosjektet så kan det
tenkes at vi kommer til å jobbe mer på samme måte og på den måten forebygger forvirrende situasjoner. Et 
eksempel på noe vi er blitt enig om er å bruke engelsk i kildekoden med variabelnavn som gir mening. Vi har også blitt
enig om at vi skal ha kommentarer på kode som vi tenker er litt forvirrende for andre. 

Kanban hjelper oss å 

### Organisering av team 
Vi tar møter alltid i gruppetimene, siden det er obligatorisk.
Vi har møter tirsdag, onsdag kl.16:00 og gruppe fredag kl.10:00.
Vi bruker Discord med chat og talekanal for å kommunisere med hverandre. 
Bruker projectboards på :octocat: Github fordi da har vi alt samlet et sted og kan integrere issues og pull requests lett. 
Prosjektmetodikk vi tenker å bruker er Kanban. Vi lager issues på Github som kommer
#### Git branching
Vi vil gjerne ha en hoved branch med release, en beta/develepor branch hvor vi alle sammen brancher ut fra for å så lage en "Pull request" tilbake til dev branchen. Og så til slutt så tar vi å merger main med dev branch. 

#### Kodestil 
Objektorientert med hovedsaklig engelske variabelnavn og kommentarer/javadocs


## Oppgave 3 - Oversikt over MVP


- [ ] Lage en spesifikasjon som inneholder:
    - [ ] kort beskrivelse av det overodnede målet for applikasjonen
    - [ ] En liste over brukerhistorier til spillet basert på MVP kravene
        - [ ] Hver brukerhistorier skal ha akseptansekriterier og arbeidsoppgaver
        - [ ] Skal ha beskrivelse av hvilket krav brukerhistorien oppfyller (dette er noe som vi legger til brukerhistorien når)


## Spesifikasjonen vår :D

### Overordnede mål 

Målet med prosjektet er å lage en morsom, enkel og brukbar versjon brettspillet Roborally.

Robot, online-multiplayer(P2P), vegg, kort, hull, belter, kjappe belter, laser, liv/død, rotore, runder og faser, 
flag, startposisjoner, skiftenøkkel, hammer og skiftenøkkel, Spiller hud (UI), Programmeringsbrett, Spillbrett, tester,


### Brukerhistorier
1. Som en spiller så må jeg kunne se spillbrettet for å plannlegge trekkene sine.
    - Akseptansekriterier:
    spilleren må kunne se brettet
    
2. Som en spiller så må jeg kunne se plasseringen til roboten for å vite hvor jeg begynner spillet mitt.
    - Akseptansekriterier:
    robotbrikken må vises på spillbrettet og være plassert på spawnpoint 
    
3. Som en spiller så må jeg kunne ha muligheten til å vinne/tape for at spillet skal kunnes avsluttes. 
    - Akseptansekriterier:
        Spilleren må vite hvor flagget er, slik at de har muligheten for å vinne spillet.
        Spilleren må også vite hvor hullet ligger, og hvor mye skade de har tatt slik at de vet når de dør. 

    - Gitt at spilleren står på flagget:
        Må spilleren vite at de står på flagget.

    - Gitt at spilleren står på hullet:
        Må spilleren vite at de står på hullet.

    - Gitt at spilleren tar skade:
        Må spilleren vite hvor mye skade de har tatt.

4. Som en Robot vil jeg ha kontroll på hvor jeg kan gå og hva som er rundt meg. 
    - Akseptansekriterier:
        - roboten må kunne see vite hva som er på brettet og hvor,
          slik at den kan holde seg til dem tingene som er på brettet.  
    
        - gitt at brettet er tomt
          må roboten også vite at brettet er tomt og at den kan bevege seg der den skal.
      
        - gitt at det er et objekt på brettet
          må roboten vite hvor objekte er slik at den kan gjøre riktig handlig når den møter objektet.  
          
7. Som en spiller må jeg kunne få utdelt ni kort.
    - Akseptansekriterier:
        - Hver spiller må få ni kort fra en kortbunke som skal være tilfeldig stokket
    
8. Som en spiller må jeg kunne se de ni kortene og velge ut fem av dem.
    - Akseptansekriterier:
        - Spilleren ser de 9 kortene 

9. Som en spiller må de valgte kortene mine kunne styre roboten min på brettet.
    - Akseptansekriterier:

9. Som en spiller må jeg kunne se menyen slik at jeg kan starte spillet.
    - Akseptansekriterier:
    Når spilleren er i hovedmenyen må han/hun kunne se en knap som starter spillet.
10. Som spiller må jeg kunne ha muligheten til å gi inputs til spillet slik at jeg kan bevege roboten min.
    - Akseptansekriterier:
    Programmet må kunne kjøre spesifikke funksjoner basert på hvilken knapper spilleren trykker på.
11. Som spiller trenger jeg å kunne åpne menyen slik at jeg kan stoppe spillet.
    - Akseptansekriterier:
    Spilleren må kunne trykke på en knapp for å kunne få opp menyen til spillet.



Som utviklert trenger jeg å kunne kalle bevegelses funksjoner for å se om funksjonene virker.

### Prioritert liste over brukerhistorier i første iterasjon




## Oppgave 4



## Prosjekt-retrospektiv

MVP krav:
1. Vise et spillebrett
2. Vise brikke på spillebrett
3. Flytte brikke (vha taster e.l. for testing)
4. Robot besøker flagg
5. Robot vinner ved å besøke flagg
6. Spille fra flere maskiner (vise brikker for alle spillere, flytte brikker for alle spillere)
7. Dele ut kort
8. Velge 5 kort
9. Bevege robot ut fra valgte kort

