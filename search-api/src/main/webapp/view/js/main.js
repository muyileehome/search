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
    // �ǵģ��������Ƕ�ף�
    getAuthorFullName: function(){
        return this.author.firstName + " " + this.author.lastName;
    }
};

document.write(language.getName)