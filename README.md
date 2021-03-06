# Progetto Login - Gabriel Rocca | Teodor Mitrofan 

<h1> Indice </h1>
I: Introduzione <br>
II: Convenzioni utilizzate <br>



<h2> I: Introduzione </h2>
<p align="justify">Il progetto richiede lo sviluppo di un'applicazione Android che permetta all'utente di accedere a un'area personale, a registrarsi per ottenere un'area personale. <br><br>
Inoltre, l'utente ha la possibilità di modificare la propria password tramite la propria area personale.<br><br>
L'applicazione possiede già caricato un'account "admin" che ha la possibilità di assegnare dei poteri "superuser" ad altri utenti, tramite una lista di tutti gli utenti     registrati sul dispositivo.<br><br>
L'applicazione deve avere una User Interface semplice e minimale, per permettere all'utente di svolgere le azioni desiderate nel minor tempo possibile, e con la massima  efficienza. <br><br>
Abbiamo optato a una UI pulita, infatti, all'interno dell'applicazione dominano 3 colori:

- BIANCO: #FFFFFFFF

- TEAL 700: #FF018786

- TEAL 750: #174950 (una variante del colore predefinito teal 700)

<br>
Il percorso utente è molto semplice e intuitivo, grazie anche alla UX creata con uno standard comune ai servizi già presenti sul mercato.
<br>
<br>
Abbiamo sviluppato l'app per step (seguendo quindi una mappa logica collegata alle azioni dell'utente).
<br>
<br>
Per la realizzazione, abbiamo impiegato +22h ca. in modalità Pair Programming, con una media di 5 ore al giorno. <br>
</p>

<h2> II: Convenzioni utilizzate </h2>
Per l'indentazione, abbiamo strutturato il codice in modo che gli elementi venissero rappresentati in modo nidificato rispetto al Layout che li conteneva.
<br>
Esempio: 
<pre>
<code>
 &lt;RelativeLayout&gt;
    &lt;EditText>&lt;/EditText&gt;
    &lt;Button>&lt;/Button&gt;
 &lt;/RelativeLayout&gt;
 </code>
 </pre>
 Per gli ID da attribuire agli elementi dell'applicazione, si segue la seguente formattazione:
<pre><code>
                          /nomeElemento_FunzionePrincipale_ActivityPartenza_EventualeActivityDestinazione
RIGA 100: android:id= @+id/viewText    _LinkRegister      _Login           _Register
                </code></pre>
