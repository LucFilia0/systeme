### 29/04/2024

# Assembleur ARMv7

## 2. TABLEAUX

### 5

Traduire le programme suivant en ARM.

Code en C :
```c
int min(int *arr, int size) {

    if(size <= 0) return 0;
    
    int res = arr[0];
    
    while(--size > 0) {
        if(arr[size] < res)
            res = arr[size];
    }
    
    return res;
}
```

Code en ASM :
* __res__ dans __r0__
* __arr__ dans __r1__
* __size__ dans __r2__
* Valeur temporaire dans __r3__

```asm
    .global min
    
min :
    @ première comparaison
    cmp r2, #0
    movle r0, #0
    bxle lr
    
    @ int res = arr[0];
    ldr r0, [r1]
    
loop :
    sub r2, r2, #1
    cmp r2, #0
    bxle lr
    ldr r3, [r1, r2 * 4] @ sizeof(int) = 4
    cmp r3, r0
    movlt r0, r3
    b loop

main :
    push {lr}
    ldr r0, [r1, #4] @ Ordinateur 32 bits, donc les pointeur font 4 octets, et pas 8
    bl atoi @ appel de fonction (branch & link)
    
```
