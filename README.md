# Numele Proiectului
TERENURI

## Descriere
plecand de la o versiune de kkat facuta in Access pe care am imbunatatit.o am ajuns sa am probleme cu ms access care se tot schimba fara a pastra compatibilitatea inapoi.
Am facut o versiuen 3 tier cu 
- MySQL
- Apache Tomcat
- JAVA+ JSP + Struts 2

## Instalare
Instrucțiuni pentru instalarea proiectului pe sistemul local.


Hei, trebuie sa invat markdown language!!
Prima parte lipseste pentru ca nu a fost creeata, dar acum sunt in faza in care am o baza de date msAccess cu mai multe inregistrari decat varianta MySQL si trebuie sa o completez.
access=67185 recorduri
mysql = 65812, o diferenta de 1300
Pentru ca nu ma pot increde in ID din cele doua baze de date am sa rad baza de date din mediul DEV si o sa incarc datele din Access
deci Export-import
Am sa pastrez si datele din Access in Github!

Deci la treaba:
- export msaccess table CRAIOVA
- sterg tabela in  mysql
### Code
use terenuri_dev;
truncate table craiova;


### 2. Wiki
GitHub oferă o funcționalitate de wiki integrată care permite crearea unei documentații mai detaliate și structurale. 

#### Pași pentru a crea un Wiki pe GitHub:
1. Navighează la repository-ul tău pe GitHub.
2. Click pe tab-ul `Wiki`.
3. Apasă pe `Create the first page` pentru a începe să adaugi conținut.

#### Exemple de pagini pentru Wiki:
- **Introducere**
- **Arhitectura proiectului**
- **Ghid de dezvoltare**
- **Ghid de contribuții**
- **FAQ**
- **Istoricul deciziilor de design**

### 3. Documente suplimentare în format Markdown
Poți crea fișiere `.md` suplimentare în repository-ul tău pentru a documenta diferite aspecte ale proiectului.

#### Exemple de fișiere suplimentare:
- `CONTRIBUTING.md`: Ghiduri pentru contribuții.
- `CHANGELOG.md`: Un jurnal al modificărilor de versiune.
- `ARCHITECTURE.md`: O descriere detaliată a arhitecturii proiectului.
- `ASSUMPTIONS.md`: O listă de ipoteze și decizii luate în timpul dezvoltării.

### 4. Issues și Pull Requests
Utilizează secțiunile `Issues` și `Pull Requests` pentru a documenta probleme, sugestii și modificări în proiect. Asigură-te că fiecare issue și pull request are o descriere detaliată.

### 5. Commit Messages
Asigură-te că mesajele de commit sunt clare și descriptive. Un bun mesaj de commit ar trebui să explice "ce" și "de ce" a fost făcută o schimbare.

### 6. Projects și Milestones
GitHub oferă și instrumente pentru managementul proiectului, cum ar fi `Projects` și `Milestones`, care te pot ajuta să organizezi și să planifici sarcinile.

### Exemple de mesaje de commit:
```plaintext
Add user authentication feature

- Implement user login
- Add JWT token generation
- Update database schema for user sessions

Fix issue #45: Correct date format in reports

- Change date format from MM/DD/YYYY to YYYY-MM-DD
- Update unit tests to reflect changes

