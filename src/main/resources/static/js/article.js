const deleteButton = document.getElementById('delete-btn');
const modifyButton = document.getElementById('modify-btn');
const createButton = document.getElementById("create-btn");
var nowDate = new Date();

if(deleteButton){
    deleteButton.addEventListener('click', event =>{
       let id = document.getElementById('article-id').value;

        var input = confirm('삭제하시겠습니까?');
        if(input){
            fetch(`/api/articles/${id}`,{
                method : 'DELETE'
            })
                .then(() => {
                    alert("삭제가 완료되었습니다.");
                    location.replace('/calendars');
                });

        }
    });
}

if(modifyButton){
    modifyButton.addEventListener('click',event => {
       let params = new URLSearchParams(location.search);
       let id = params.get('id');
        const editorData = editor.getData();
       fetch(`/api/articles/${id}`,{
           method: 'PUT',
           headers: {
               "Content-Type": "application/json",
           },
           body:JSON.stringify({
               title : document.getElementById('title').value,
               //content : document.getElementById('content').value,
               content : editorData,
               updateAt : nowDate,
           })
       })
           .then(()=>{
              alert('수정이 완료되었습니다.');
              location.replace(`/articles/${id}`);
           });
    });
}

if(createButton){
    createButton.addEventListener("click",(event) => {
        const editorData = editor.getData();
       fetch("/api/articles",{

           method : "POST",
           headers: {
               "Content-Type" : "application/json",
           },
           body : JSON.stringify({
               title:document.getElementById("title").value,
               //content:document.getElementById("content").value,
               content : editorData,
               start: nowDate,
           }),
       }).then(()=>{
           alert("등록 완료되었습니다.");
           location.replace("/calendars");
       });
    });
}



document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        eventClick: function(info) {
            var eventObj = info.event;
                info.jsEvent.preventDefault(); // prevents browser from following link in current tab.

                alert('Clicked ' + eventObj.title);
                location.replace(`/articles/${eventObj.id}`);


        },
        dayMaxEvents: true,
        initialDate: nowDate,
        events: 'http://localhost:8080/api/articles',

        initialView: 'dayGridMonth',
        headerToolbar: {
            center: 'addEventButton'
        },
        customButtons: {
            addEventButton: {
                text: '일기 작성',
                click: function() {
                    location.replace(`/new-article`);
                }
            }
        }
    });
    calendar.render();
});


let editor;
ClassicEditor
    .create( document.querySelector( '#editor' ) )
    .then( newEditor => {
        editor = newEditor;
    } )
    .catch( error => {
        console.error( error );
    } );