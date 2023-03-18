package tech.bawano.composeplayground.experiments

data class Car(var name:String, var range:Float)

fun Car.copy() = Car(this.name, this.range)

fun main(){
    val car = Car(name = "Lamborghini", range = 240f)
    val sameCar = car
    val deepCopyCar = car.copy()


    println("actual car => $car")
    println("same car => $sameCar")
    println("deep copy car => $deepCopyCar")
    println()

    //First change
    println("Changing..")
    println("car.name = \"Benz\"")
    println("sameCar.range = 350f")
    println("deepCopyCar.range = 1000f")

    car.name = "Benz"
    sameCar.range = 350f
    deepCopyCar.range = 1000f




    println("actual car => $car")
    println("same car => $sameCar")
    println("deep copy car => $deepCopyCar")
    println()

    println("Change to buggati")
    changetoBuggati(sameCar)


    println("actual car => $car")
    println("same car => $sameCar")
    println("deep copy car => $deepCopyCar")
    println()

}


fun changetoBuggati(car:Car){
    car.name = "Buggati"
    car.range = 500f
}