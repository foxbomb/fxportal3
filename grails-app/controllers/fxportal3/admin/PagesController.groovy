package fxportal3.admin

import fxportal3.Component
import fxportal3.Page
import fxportal3.PageComponent
import fxportal3.system.GenericSecurityController

import grails.converters.*

class PagesController extends GenericSecurityController {
    
    static layout = "admin"

    def index() {
        
        authorize();
        def page = new Page();
        page.id = 0
        
        def selectedId = 0;
        def pageComponents = null;
        
        try {
            selectedId = params.id.toLong()
            if (selectedId > 0) {
                pageComponents = PageComponent.withCriteria {
                    eq "page.id", selectedId
                    order "order", "asc"
                }
                page = Page.get(selectedId)
            }
        } catch (Exception ex) {
            // Do not throw an exception. Just display the index page.
        }
        
        ['pages': Page.list(), page: page, 'components': Component.list(), 'pageComponents': pageComponents]
        
    }
    
    def save() {
        
        authorize();       
        def page
        
        // Check if the page exists. No, create a new one. Yes, update it.
        
        if (params.pageId.toInteger() == 0) {            
            page = new Page(title: params.title, url: params.url)
            page.save(flush: true)
            params.id = page.id
        } else if (params.pageId.toInteger() > 0) {            
            page = Page.get(params.pageId)
            page.title = params.title
            page.url = params.url
            page.save (flush: true)
            params.id = page.id
        } else {
            throw new RuntimeException("Invalid page id received on page save")
        }
        
        // Parse the json
        
        def data = JSON.parse(params.data)
        
        // loop through new and updated
        
        data.updated.eachWithIndex() {pageComponent, index -> 
            if (pageComponent.new) {
                new PageComponent(friendlyName: pageComponent.friendlyName, page: page, component: Component.findByKey(pageComponent.key), order: index).save()
            } else {
                
                def obj = PageComponent.get(pageComponent.id)
                obj.friendlyName = pageComponent.friendlyName
                obj.order = index
                obj.save()
                
            }
        };
        
        // loop through deleted
        
        data.removed.each() {            
            def obj = PageComponent.get(it)
            obj.delete()
        }
        

        redirect action: "index", id: params.id
    }    
    
    def delete() {

        authorize();
        def page = new Page();
                
        try {
            def selectedId = params.id.toLong()
            println("selected id is $selectedId")
            if (selectedId > 0) {
                println("deleting")
                page = Page.get(selectedId)
                page.delete();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Invalid page id received on page delete")
        }
        
        flash.message = "Page Deleted"
        flash.type = "danger"
        
        redirect action: "index", id: 0
        
        
    }
}
