const cheerio = require("cheerio")
const mongoose = require("mongoose")
const fetch = require("cross-fetch")

require("dotenv").config()

var count = 0
mongoose.connect(process.env.MONGODB_URI, {useNewUrlParser: true, useUnifiedTopology: true})
const connection = mongoose.connection
connection.once('open', () => {
    console.log('MongoDB connection established')
    pre_cache()
        .then(() => {
            console.log('Completed')
        })
        .catch(err => console.log(err))
})

const Menu = require("./Menu.model")



async function pre_cache() {
    const names = ['jizza', 'jcl', 'kins', 'j2', 'littlefield', 'fast', 'cypress', 'jcm']
    const meals = ['Breakfast', 'Lunch', 'Dinner']

    for (var i = 0; i < names.length; i++) {
        const c_name = names[i]
        for (var j = 0; j < meals.length; j++) {
            const c_meal = meals[j]
            start(c_name, c_meal)
                .then(res => {
                    Menu.deleteOne({name_meal:c_name+c_meal})
                    .then(() => {
                        const newMenu = new Menu({
                            name_meal: c_name + c_meal,
                            data: res
                        })
                        newMenu.save(newMenu)
                            .then(() => {
                                count += 1

                                if (count == 24) {
                                    connection.close()
                                }
                            })
                            .catch((err) => console.log(err))
                    })
                    .catch (err => console.log(err))
                })
                .catch(err => console.log(err))
                    
        }
    }
}


async function start(name, meal) {

    var URL = ""

    if (name == "jizza") {
        URL = "https://hf-food.austin.utexas.edu/foodpro/longmenu.aspx?sName=University+Housing+and+Dining&locationNum=26"
    } else if (name == "jcl") {
        URL = "https://hf-food.austin.utexas.edu/foodpro/longmenu.aspx?sName=University+Housing+and+Dining&locationNum=01&mealName=" + meal 
    } else if (name == "kins") {
        URL = "https://hf-food.austin.utexas.edu/foodpro/longmenu.aspx?sName=University+Housing+and+Dining&locationNum=03&mealName=" + meal
    } else if (name == "j2") {
        URL = "https://hf-food.austin.utexas.edu/foodpro/longmenu.aspx?sName=University+Housing+and+Dining&locationNum=12&mealName=" + meal
    } else if (name == "littlefield") {
        URL = "https://hf-food.austin.utexas.edu/foodpro/longmenu.aspx?sName=University+Housing+and+Dining&locationNum=19&mealName=" + meal
    } else if (name == "fast") {
        URL = "https://hf-food.austin.utexas.edu/foodpro/longmenu.aspx?sName=University+Housing+and+Dining&locationNum=27&mealName=" + meal 
    } else if (name === "cypress") {
        URL = "https://hf-food.austin.utexas.edu/foodpro/longmenu.aspx?sName=University+Housing+and+Dining&locationNum=08&mealName=" + meal
    } else if (name == "jcm") {
        URL = "https://hf-food.austin.utexas.edu/foodpro/longmenu.aspx?sName=University+Housing+and+Dining&locationNum=05"
    } else {
        return []
    }

    const response = await(fetch(URL))
    const body = await response.text()

    let $ = cheerio.load(body)
    let menu_items = $("body > table > tbody > tr > td > div > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr > td > div, body > table > tbody > tr > td > div > table > tbody > tr > td > table > tbody > tr > td > table > tbody > tr > td > div > a")

    var curr_label = ""
    var format = []
    for (var i = 0; i < menu_items.length; i++) {
        var menu_element = menu_items[i]
        var text_content = $(menu_element).text()
        if (text_content.length > 1) {
            if (text_content.startsWith("--")) {
                curr_label = text_content.replace("/-/g", "").trim()
            } else if ($(menu_element).attr().href != null) {
                format.push({"name": text_content, "category": curr_label, "link":  "https://hf-food.austin.utexas.edu/foodpro/" + $(menu_element).attr().href})
            }
        }
    }
    
    return format
}