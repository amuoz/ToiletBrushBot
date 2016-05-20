@S
return
@1#¿Quién eres?
_Pelo_ : Soy tu primer *pelo* pubertoso, soy tu *pelo* de adolescencia.
option-off 1
option-on 2 3
return
@2#off#¿Puedo arrancarte de mi mejilla?
_Pelo_ : Vale, pero primero te arranco yo las piernas ¿hay trato?.
_Plunger_ : Eso no suena demasiado bien...mejor lo dejamos estar.
option-off 2
return
@3#off#Tengo algunas dudas a cerca de los pelos de adolescencia.
_Pelo_ : Adelante. Veamos hasta dónde llega tu ignorancia.
go-to dPelo2.md
@4#Adios Pubert.
_Pelo_ : Adiós. Y recuerda, si dejas que crezca mucho me saldrán granos alrededor.
stop