.data
msg: .ascii "Hello FDP\n\0"

.text
.global _start
_start:
	mov $1, %rax
	mov $12, %rdi
	mov msg, %rsi
	mov $11, %rdx
	syscall

	mov $60, %rax
	mov $12, %rdi
	syscall
