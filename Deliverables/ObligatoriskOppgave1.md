# Gruppe 8 - Runtime Terror Import Team_Name Error 404 Team Name Not Found 

## Oppgave 1


Vi har valg teamnavnet **Runtime Terror Import Team_Name Error 404 Team Name Not Found**.

Belmin:
Er 2. semester student på datasikkerhet, hadde `INF100` i fjor, og tar `INF112` ved siden av INF101 nå. 
Er relativ ny til Java programering, men har brukt Python en liten del. 

Martin er 6. semesters student på IMØ med fagene `INF100-102`, `INF140` og `INF142`. 
Har ikke programmert så mye i det siste så er litt rusten. 
Er interresert i nettverk og datamaskinarkitektur system utvikling. 


Thomas har studert 1,5 år i Tromsø. 
Her har han fulført fag som "Innføring i programmering", "Objekt orientert programering" og 
"Datastrukturer og algoritmer". I Bergen er han på sit andre semester og har fullført
fag som `INF122` og `INF140`.

Odin
2 Semester student på datasikkerhet, ferdig med `Inf100` og holder på med `Inf101`.
Har gått år tidligere på HVL hvor jeg var borti java programering. 
Tidligere erfaring fra IT 1 og IT 2 fra vgs. Også litt erfaring fra FHS teknologi linje. 


Kim Andre
4 semester på bachelor data vitenskap. har hatt fagene `INF100`, `INF101`, `INF102`, `INF122`, `MNF130`,
og diverse matte fag. Har erfaringer i java fra `INF101` og `INF102`


Alle i teamet har på noe erfaring med programmering. 
Alle har vært skrevet noe java før men det er stor variasjon i gruppen på hvor mye, hvor enkelte har en
mer erfaring en andre.

### Roller
[Martin](https://github.com/mrtineide) tar rolle som teamleder fordi han har erfaring som leder.
- Leder teammøter
- Holder orden/ryddig/systematisk project board
- Har ansvar for at kodekvalitet og merge inn i master branch
- Har ansvar for at folk gjør sine oppgaver
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

### Hvordan holde god kodekvalitet og dokumentasjon (diskusjon)
Ved å bruke testdrevet metodikk så har vi en metode som tvinger oss til å tenke gjennom hva vi trenger å gjøre.
Når vi alle sammen er enig og snakket sammen om hvilke forventninger og regler vi skal ha for prosjektet så kan det
tenkes at vi kommer til å jobbe mer på samme måte og på den måten forebygger forvirrende situasjoner. Et
eksempel på noe vi er blitt enig om er å bruke engelsk i kildekoden med variabelnavn som gir mening. Vi har også blitt
enig om at vi skal ha kommentarer i koden de vi tenker er litt forvirrende for andre.
I møtene så skal
vi  fortelle hva vi har jobbet med siden sist 
og teamleder legger en agenda for dagen.
Det at vi møter ofte og til faste tider hvor vi oppdaterer hverandre vil holde hverande oppdatert og 
man har også mulighet for å stille spørsmål.
[Kanban](https://www.atlassian.com/agile/kanban) metoden vil hjelpe oss med:
- å prioritere oppgaver ved at man begrenser hvor mye man jobber med nå,
- holder hverandre oppdatert på hva andre jobber med ved å ha et visuelt brett med full oversikt

### Organisering av team 
Vi tar møter alltid i gruppetimene, siden det er obligatorisk.
Vi har møter tirsdag, onsdag kl.16:00 og gruppe fredag kl.10:00.
Vi bruker Discord med chat og talekanal for å kommunisere med hverandre. 
Bruker projectboards på Github :octocat: fordi da har vi alt samlet et sted og kan lett integrere issues og 
pull requests. Prosjektmetodikk vi tenker å bruker er Kanban, altså hva vi jobber med bestemmes av prosjektbrettet. 
Vi lager issues på Github som kommer automatisk som kort på prosjekt brettet vårt eller lager kort direkte på brettet.
#### Bruk av Git og [Gitflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow)
Vi vil ha en hoved branch med release, en beta/develepor branch hvor vi alle sammen brancher vårt arbeid ut ifra
for å så lage en "Pull request" tilbake til dev branchen. I denne PR så kan alle andre komme med innspill og når 
noen andre har gått gjennom og godkjent endringen så kan det merges med dev branch.
Og før hver innlevering så tar vi til slutt å merger dev branch med main branch.
Dette er en git metode som gjerne kalles 
[Gitflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) 

#### Kodestil 
Vi skal hovedsaklig skrive objektorientert kode med engelske variabelnavn og kommentarer/javadocs. 


## Oppgave 3 - Oversikt over MVP

## Spesifikasjonen vår

### Overordnede mål 

Målet med prosjektet er å lage en morsom, enkel og brukbar versjon brettspillet Roborally.

Robot, online-multiplayer(P2P), vegg, kort, hull, belter, kjappe belter, laser, liv/død, rotore, runder og faser, 
flag, startposisjoner, skiftenøkkel, hammer og skiftenøkkel, Spiller hud (UI), Programmeringsbrett, Spillbrett, tester,


### Brukerhistorier
1. Som en spiller så må jeg kunne se spillbrettet for å plannlegge trekkene sine.
    - Akseptansekriterier:
    spilleren må kunne se brettet
    - Arbeidsoppgave: 
        - [ ] Lage kode med rammeverket LIBgdx slik at man får man opp et brett
    
2. Som en spiller så må jeg kunne se plasseringen til roboten for å vite hvor jeg begynner spillet mitt.
    - Akseptansekriterier:
    robotbrikken må vises på spillbrettet
    - Arbeidsoppgave:
      - [ ] Få frem brikken grafisk på brettet
    
3. Som en spiller så må jeg kunne ha muligheten til å vinne og tape for at spillet skal kunne avsluttes. 
    - Akseptansekriterier:
      - Spilleren må se hvor flagget er
      - Spilleren må få se hvor hullet ligger
      - Spilleren må  få tilbakemelding om at de er dø.
      - Gitt at spilleren står på flagget:
        Må spilleren få tilbakemelding om at de står på flagget.

      - Gitt at spilleren står på hullet:
        Må spilleren få tilbakemelding om at de står på hullet.

      - Gitt at spilleren tar skade:
        Må spilleren  få tilbakemelding på hvor mye skade de har tatt.

   - Arbeidsoppgave: 
       - [ ] Få flagget til å vises på brettet
       - [ ] Få hullet synlig på brettet
       - [ ] Lage logikk som gir tilbakemelding til spilleren om de er dø når de gikk over hullet
       - [ ] Lage logikk som gir tilbakemelding til spilleren om at de står på flagget 
       - [ ] Lage logikk som gir tilbakemelding til spilleren om hvor mye skade de har tatt

4. Som en Robot vil jeg ha kontroll på hvor jeg kan gå og hva som er rundt meg. 
    - Akseptansekriterier:
        - roboten må kunne se vite hva som er på brettet og hvor,
          slik at den kan forholde seg til dem tingene som er på brettet.  
    
        - gitt at brettet er tomt
          må roboten også vite at brettet er tomt og at den kan bevege seg der den skal.
      
        - gitt at det er et objekt på brettet
          må roboten vite hvor objekte er slik at den kan gjøre riktig handlig når den møter objektet.
    - Arbeidsoppgave:
        - [ ] Skrive logikk så roboten har informasjon om hva som er på brettet
        - [ ] Skrive logikk slik at roboten samhandler med andre objekter slik det er beskrevet i spillreglene
        - [ ] Gjøre det slik at roboten ikke beveger seg gjennom ting som den ikke kan gå gjennom per spillreglene
7. Som en spiller må jeg kunne få utdelt ni kort for å kunne programmere roboten.
    - Akseptansekriterier:
       - Hver spiller må få ni kort fra en kortbunke som skal være tilfeldig stokket
   - Arbeidsoppgave:
     - [ ] Lage en virtuell kortstokk
     - [ ] Lage logikk som i funsjon gjør at kortene er stokket tilfeldig i kortstokken(e)
     - [ ] Lage en logikk som gir det mulig å ta/trekke et kort ut i fra kortstokke(e)
     - [ ] Lage en logikk som sjekker at hver spiller får riktig antall kort etter spillreglene     
8. Som en spiller må jeg kunne se de ni kortene og velge ut fem av dem.
    - Akseptansekriterier:
        - Spilleren ser de ni kortene 
        - Spilleren kan velge minst et av de 9 kortene
        - Spilleren ser hvilke av de 9 kortene som er valgt
    - Arbeidsoppgave:
      - [ ] Vise grafisk de kortene som spilleren har
      - [ ] Lage logikk så spilleren kan markere riktig antall kort etter spillreglene
      - [ ] Vise grafisk de kortene som spilleren har valgt
9. Som en spiller må de valgte kortene mine kunne styre roboten min på brettet.
    - Akseptansekriterier:
        - Spilleren må kan velge rekkefølgen på de fem kortene som skal styre robotene 
        - Spilleren må kan se prioriteringspoengene på kortene sine.
    - Arbeidsoppgave:
        - [ ] Lage logikk som holder orden på rekkefølgen kortene ble valgt
        - [ ] Vise visuelt prioritetspoengene på kortene til spilleren
        - [ ] Vise visuelt rekkefølgen på kortene som ble valgt 
9. Som en spiller må jeg kunne se menyen slik at jeg kan starte spillet.
    - Akseptansekriterier:
    Når spilleren er i hovedmenyen må han/hun kunne se en knapp som starter spillet.
    - Arbeidsoppgave:
        - [ ] Vise visuelt en hovedmeny som har knapp som starter spillet
        - [ ] Lage logikk som starte spillet når en knapp er trykket på
        - [ ] Vise visuelt spillet når det starter
11. Som spiller trenger jeg å kunne åpne menyen slik at jeg kan stoppe spillet.
    - Akseptansekriterier:
    Spilleren må kunne trykke på en knapp for å kunne få opp menyen til spillet.
    - Arbeidsoppgave:
        - [ ] Lage logikk og vise visuelt en pausemeny som pauser spillet 
        - [ ] Lage logikk og vise visuelt en knapp som tar en tilbake til hovedmenyen
        - [ ] Lage logikk og vise visuelt en knapp som avslutter spillet 
12. Som utvikler trenger jeg å kunne bruke piltaster/WASD for å bevege en robot for å kunne bevege roboten til flagget:
    - Akseptansekriterier:
      Brikken flytter seg i samme retning som piltastene/WASD
    - Arbeidsoppgave:
        - [ ] Lage logikk som flytter roboten og at roboten visuelt er flyttet i riktig retning  


### Prioritert liste over brukerhistorier i første iterasjon
1. Som en spiller så må jeg kunne se spillbrettet for å plannlegge trekkene sine.
2. Som en spiller så må jeg kunne se plasseringen til roboten for å vite hvor jeg begynner spillet mitt.
3. Som en spiller så må jeg kunne ha muligheten til å vinne og tape for at spillet skal kunne avsluttes.
12. Som utvikler trenger jeg å kunne bruke piltaster/WASD for å bevege en robot for å kunne bevege roboten til flagget:
    - Akseptansekriterier:
      Brikken flytter seg i samme retning som piltastene/WASD
    - Arbeidsoppgave:
        - [ ] Lage logikk som flytter roboten og at roboten visuelt er flyttet i riktig retning



## Oppgave 4
Arbeidsoppgaver som må bli løst er for å realisere brukerhistoriene:
- Få UI og backendbrettet til å snakke med hverandre. Så vi kan bevege brikker på brettet og dekke MVP kravet. 


## Prosjekt-retrospektiv

Planlagt:
1. Gjøre ferdig de fem MVP oppgavene (Thomas og Kim).
2. Tenkte å komme i gang koden til å dele ut og bruke kort. (utenfor mvp) (Odin og Belmin).
3. Skrive møtereferater av møtene vi har (Belmin).
4. Prøvde å bruke testdreven metodikk (Gruppen).
5. Planlagt å ha møter etter hver forelesning og gruppetimen (Grupper) .
6. Skrive innlevering 1 (Belmin).
7. Vi skulle bruke prosjektbrettet og Kanban til å styre hva vi jobbet med.

Gjort:
1. Ble ferdig jobbet og commited til prosjektet.
2. Ble jobbet med men ikke noe ferdig kode, endte med at vi ikke fikk noen commits til githuben til gruppen.
3. Alle møtene ble skrevet ned, Ansvaret ble senere gitt over til alle. Fordi medlem trakk seg fra faget. 
4. Endte med at det ikke ble brukt i prosjektet. Fordi vi begynte å kode før vi skrev tester.
5. Møtene etter timene måtte flyttes til senere på dagen for at det skulle passe for alle. 
6. Martin hadde startet å skrive innleveringen før vi fikk fordelt ansvarene skikkelig, så han endte med å skrive den ferdig.
7. Prosjektbrettet var ikke så bra satt opp i starten, så ble ikke brukt veldig aktivt i starten men ble bedre utover uken.

Det å programmere sammen førte til at det ble enklere å skrive kode, som var forstålig for den andre parten.
Thomas og Kim har parprogrammert mye sammen for å klare MVP kravene, og de fikk mest fremgang når man kodet sammen.
Vi burde vi bli flinkere til å ta utgangspunk i brukerhistorier og tester før vi begynner å kode. Slik det var i starten så
begynte vi å kode bare for å se hvordan ting fungerer for i ettertid skrive brukerhistorier og tester.
