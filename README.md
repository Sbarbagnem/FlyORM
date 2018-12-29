# Assignment 3

## Componenti

Ventura Samuele: 793060

Repository gitlab: https://gitlab.com/s.ventura/assignment3.git

## Progetto

Per il progetto si è scelto di modellare il dominio rappresentante i voli, secondo il seguente schema:

![](/home/samuele/Assignment3/Schema/schema.png)

Nello specifico si è sfruttato il FrameWork Spring che mette a disposizione un'implementazione del modello JPA.

Le entità modellate sono quattro:

* CompagniaAerea che rappresenta la compagnia che offre il volo.
* Aereo che rappresenta l'aeromobile utilizzato per il viaggio.
* Aeroporto .
* Volo che rappresenta il viaggio.

Tra queste entità sono state modellate le seguenti relazioni:

* Una self-relation in CompagniaAerea che indica la possibilità che una compagnia ne possegga altre e quindi queste facciano parte di un gruppo.
* Una relazione many-to-one tra Volo e Aeroporto perché un volo ha un solo aeroporto di arrivo e uno solo di partenza ma più voli possono avere gli stessi aeroporti.
* Una relazione many-to-one tra Volo e Aereo perché un aereo può eseguire diversi voli, mentre un volo può essere eseguito da un solo aereo.
* Una relazione many-to-one tra CompagniaAerea e Volo perché il volo è offerto da una singola compagnia che però offre più voli solitamente.