### 29/04/2024

# Differents types d'architecture

__RISC__ : Reduced Instruction Set Computer
    * Simple pour le CPU
    * Les instructions ne font qu'une chose -> _load-and-store_
    * Encodage des instructions de taille fixe (sur le même nombre de bits - 32)

__CISC__ : Complex Instruction Set Computer
    * Complexe pour le CPU
    * Instructions complexes : ajouter un registre à une case RAM
    * Encodage de taille variable

# Encodage des instructions en ARM

2 encodages :
    * __ARM ou A32__ -> 32 bits par instruction (ou 16 bits)
    * __Thumb__ -> 16 bits par instruction (plus efficace pour le cache)

Le CPU a un bit qui est dans le registre d'état qui indique si il est en mode *ARM* ou *Thumb*.

L'instruction `bx` : Comme un `b` + peut changer entre *ARM* et *Thumb* avec le bit décrit ci-dessus. Ainsi, on s'assure de revenir dans le bon mode lorsqu'un appel de fonction est réalisé par exemple.

# Encodage (pour de vrai)

### Ex 1 :

`sub r0, r1, r2`

    * __Cond__ : La condition à remplir pour exécuter l'instruction (`1110` : __ALWAYS__)
    * __OpCode__ : Le code de l'instruction que l'on est en train de réaliser (`0010` : __SUB__)
    * __Rn__ : Premier registre d'opération
    * __Rd__ : Registre de destination
    * __Operand2__ : Deuxième registre d'opération (__Shift__ + __R2__ : Deuxième registre)

| Cond | 00 | 1 | OpCode | S | Rn   | Rd   | Shift     | R2   |
| ---- | -- | - | ------ | - | ---- | ---- | --------- | ---- |
| 1110 | 00 | 1 | 0010   | 0 | 0001 | 0000 | 000000000 | 0010 |

### Ex 2 :

`mula a1, a2, a4, a3` (`mula` = `mul` + `add` fin)

    * __Cond__ : Condition pour réaliser l'instruction
    * __A__ (Accumulate) : 0 = _Multiply only_ / 1 = _Multiply and accumulate_
    * __S__ (Set condition code) : 0 = _Do not alter condition codes_ / 1 = _Set condition codes_
    * __Rd__ : Registre de destination
    * __Rn__, __Rs__, __Rm__ : Registres d'opération

| Cond | 000000 | A | S | Rd   | Rn   | Rs   | 1001 | Rm   |
| ---- | ------ | - | - | ---- | ---- | ---- | ---- | ---- |
| 1110 | 000000 | 1 | 0 | 0000 | 0001 | 0011 | 1001 | 0001 |
