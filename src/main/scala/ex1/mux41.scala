package ex1

import chisel3._
import chisel3.util.switch
import chisel3.util.is

class MUX41 extends Module {
  val io = IO(new Bundle {
    val in=Input(UInt(10.W))
    val bit = Input(Bool())
    val out=Output(UInt(10.W))

    // val sel = Input(UInt(2.W))
    // val X = Input(Bits(4.W))
    // val Y = Output(Bits(1.W))
    // val value1        = Input(UInt(16.W))
    // val value2        = Input(UInt(16.W))
    // val loadingValues = Input(Bool())
    // val outputGCD     = Output(UInt(16.W))
    // val outputValid   = Output(Bool())
  })
  val bools=VecInit(io.in.asBools)
  bools(0):=io.bit
  io.out:=bools.asUInt

//io.Y:=io.X+io.sel
  // switch(io.sel){
  //   is("b00".U(2.W)){
  //     io.Y:=io.X(1)
  //   }
  // }

  // val x  = Reg(UInt())
  // val y  = Reg(UInt())

  // when(x > y) { x := x - y }
  //   .otherwise { y := y - x }

  // when(io.loadingValues) {
  //   x := io.value1
  //   y := io.value2
  // }

  // io.outputGCD := x
  // io.outputValid := y === 0.U
}

object MUX41 extends App {
    emitVerilog(new MUX41(),Array("--target-dir", "output/ex1"))
  //new ChiselStage().emitVerilog(new MUX41())
}
