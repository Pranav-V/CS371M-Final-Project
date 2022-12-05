const mongoose  = require("mongoose")
const Schema = mongoose.Schema

const MenuSchema = new Schema({
    name_meal: {type:String,required:true},
    data: {type:Object,required:true}
}, {
    timestamps:true
})

const Menu = mongoose.model("Menu", MenuSchema)
module.exports = Menu