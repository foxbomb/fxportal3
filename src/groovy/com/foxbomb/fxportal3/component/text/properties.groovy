package com.foxbomb.fxportal3.component.text


// Profiles are [default, web, smartphone, featurephone, mxit]

key = "com.foxbomb.fxportal3.component.text"

mode = "automatic"
fields = ["text", "markdown", "paginate", "wordsperpage"]
instructions = "Please enter the content of the article in the textbox below. Soon, this will support markdown syntax."

fieldDetail {
    text = [title:"Text", type:"memo", "required":true, "help":"Create your article here"]
    markdown = [title:"Use Markdown", type:"yesno", "help":"Use markdown syntax?", "default":"yes"]
    paginate = [title:"Paginate", type:"yesno", "help":"Would you like the text split into multiple pages?", "default":"yes"]
    wordsperpage = [title:"Words per Page", type:"number", "default":1000, "help":"How many words until spilling over to next page?"]
}

profiles {

    "default" {
    }

    "web" {
    }

    "smartphone" {
    }

    "featurephone" {
    }

    "mxit" {
    }    

}