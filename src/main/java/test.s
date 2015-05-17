	.file	"test.cpp"

	.ident	"GCC: (Ubuntu/Linaro 4.6.3-1ubuntu5) 4.6.3 LLVM: exported"


	.text
	.globl	_Z4funcv
	.align	16, 0x90
	.type	_Z4funcv,@function
_Z4funcv:
.Ltmp2:
	.cfi_startproc
	pushq	%rbp
.Ltmp3:
	.cfi_def_cfa_offset 16
.Ltmp4:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
.Ltmp5:
	.cfi_def_cfa_register %rbp
	movl	$239, -4(%rbp)
	movl	-4(%rbp), %eax
	popq	%rbp
	ret
.Ltmp6:
	.size	_Z4funcv, .Ltmp6-_Z4funcv
.Ltmp7:
	.cfi_endproc
.Leh_func_end0:

	.globl	main
	.align	16, 0x90
	.type	main,@function
main:
.Ltmp10:
	.cfi_startproc
	pushq	%rbp
.Ltmp11:
	.cfi_def_cfa_offset 16
.Ltmp12:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
.Ltmp13:
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	callq	_Z4funcv
	leaq	.cst, %rdi
	movl	%eax, %esi
	movb	$0, %al
	callq	printf
	movl	$0, -4(%rbp)
	movl	%eax, -8(%rbp)
	movl	-4(%rbp), %eax
	addq	$16, %rsp
	popq	%rbp
	ret
.Ltmp14:
	.size	main, .Ltmp14-main
.Ltmp15:
	.cfi_endproc
.Leh_func_end1:

	.type	.cst,@object
	.section	.rodata,"a",@progbits
	.align	8
.cst:
	.asciz	 "%d"
	.size	.cst, 3


	.section	".note.GNU-stack","",@progbits
