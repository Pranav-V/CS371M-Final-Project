// in a new folder b e sure to run "npm init -y" a nd "npm install puppeteer"
const express = require("express")
const cors = require("cors")
const http = require("http")
const router = express.Router()
const mongoose = require("mongoose")
const Menu = require("./Menu.model")
require("dotenv").config()


const PORT = process.env.PORT || 5000

const app = express()
const server = http.createServer(app)

mongoose.connect(process.env.MONGODB_URI, {useNewUrlParser: true, useUnifiedTopology: true})
const connection = mongoose.connection
connection.once('open', () => {
    console.log('MongoDB connection established')
})

app.use(express.json())
app.use(cors())

app.use(router)

server.listen(PORT, () => {
    console.log(`Server is running on port: ${PORT}`)
})

router.route('/retrieveMenuData').get((req, res) => {
    Menu.find({name_meal: req.query.name + req.query.meal})
        .then(data => {
            res.json(data[0].data)
        })
        .catch(err => console.log(err))
})