/**
 * Created by Administrator on 2015/12/16.
 */
var language = {
    name: 'JavaScript',
    isSupportedByBrowsers: true,
    createdIn: 1995,
    author:{
        firstName: 'Brendan',
        lastName: 'Eich'
    },
    // 是的，对象可以嵌套！
    getAuthorFullName: function(){
        return this.author.firstName + " " + this.author.lastName;
    }
};

document.write(language.getName)