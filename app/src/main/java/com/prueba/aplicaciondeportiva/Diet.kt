package com.prueba.aplicaciondeportiva

 class Diet {

     private var name : String = ""
     private var description : String = ""

     private var monday : DayDiet = DayDiet()
     private var tuesday : DayDiet = DayDiet()
     private var wednesday : DayDiet = DayDiet()
     private var thursday : DayDiet = DayDiet()
     private var friday : DayDiet = DayDiet()
     private var saturday : DayDiet = DayDiet()
     private var sunday : DayDiet = DayDiet()

     constructor()
     constructor(name: String, description: String, monday: DayDiet, tuesday: DayDiet,
                 wednesday: DayDiet, thursday: DayDiet, friday: DayDiet,
                 saturday: DayDiet, sunday: DayDiet){
         this.name = name
         this.description = description
         this.monday = monday
         this.tuesday = tuesday
         this.wednesday = wednesday
         this.thursday = thursday
         this.friday = friday
         this.saturday = saturday
         this.sunday = sunday
     }

     //region getters
     fun getName() : String {return name}
     fun getDescription() : String {return description}
     fun getMonday() : DayDiet {return monday}
     fun getTuesday() : DayDiet {return tuesday}
     fun getWednesday() : DayDiet {return wednesday}
     fun getThursday() : DayDiet {return thursday}
     fun getFriday() : DayDiet {return friday}
     fun getSaturday() : DayDiet {return saturday}
     fun getSunday() : DayDiet {return sunday}
     //endregion

     //region getters
     fun setName(name : String){ this.name = name}
     fun setDescripcion(description : String){ this.description = description}
     fun setMonday(monday : DayDiet){ this.monday = monday}
     fun setTuesday(tuesday : DayDiet){ this.tuesday = tuesday}
     fun setWednesday(wednesday : DayDiet){ this.wednesday = wednesday}
     fun setThursday(thursday : DayDiet){ this.thursday = thursday}
     fun setFriday(friday : DayDiet){ this.friday = friday}
     fun setSaturday(saturday : DayDiet){ this.saturday = saturday}
     fun setSunday(sunday : DayDiet){ this.sunday = sunday}
     //endregion

     class DayDiet {
        private var breakfast : String = ""
        private var lunch : String = ""
        private var meal : String = ""
        private var snack : String = ""
        private var dinner : String = ""

         constructor()
         constructor(breakfast: String, lunch: String, meal: String, snack: String, dinner: String){
             this.breakfast = breakfast
             this.lunch = lunch
             this.meal = meal
             this.snack = snack
             this.dinner = dinner
         }

        //region getters
        fun getBreakfast() : String {return breakfast}
        fun getLunch() : String {return lunch}
        fun getMeal() : String {return meal}
        fun getSnack() : String {return snack}
        fun getDinner() : String {return dinner}
        //endregion

        //region getters
        fun setBreakfast(breakfast : String){ this.breakfast = breakfast}
        fun setLunch(lunch : String){ this.lunch = lunch}
        fun setMeal(meal : String){ this.meal = meal}
        fun setOnces3(snack : String){ this.snack = snack}
        fun setDinner(dinner : String){ this.dinner = dinner}
        //endregion
    }
}