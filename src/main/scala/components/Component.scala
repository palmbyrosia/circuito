package com.circuito.components

class Component(nInputs: Int, nOutputs: Int, inputs: List[Signal], outputs: List[Signal]) {
  require(inputs.length == nInputs, "Number of input signals does not match the given number of inputs")
  require(outputs.length == nOutputs, "Number of output signals does not match the given number of outputs")

  def computeOutput(): List[Signal] = {}
  
  def getInput(index: Int): Signal = inputs(index)
  def getOutput(index: Int): Signal = outputs(index)
  
  def setInput(index: Int, value: Signal): Unit = {
    require(index >= 0 && index < nInputs, s"Input index $index is out of bounds")
    inputs(index) = value
  }
  
  def setOutput(index: Int, value: Signal): Unit = {
    require(index >= 0 && index < nOutputs, s"Output index $index is out of bounds")
    outputs(index) = value
  }
}
