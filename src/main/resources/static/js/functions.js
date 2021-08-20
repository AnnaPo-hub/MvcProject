
function getAllBooks(){
        $.get('/api/book').done(books => printAllBooks(books))
}

function printAllBooks(books){
    if(typeof books !== 'undefined' && books.length >0){
    books.forEach(function(book){
    $('tbody').append(`
         <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.genre}</td>
            <td>
               <button onclick="deleteBook(${book.id})">Delete</button>
             </td>
             </tr>
             `)

    });
    }else {
        $('tbody').append(`
                        <tr>
                            <td colspan="2"> No Books Available </td>
                        </tr>
                 `)
    }
    }


  function deleteBook(id) {
         $.ajax({
             type: 'DELETE',
             url: '/api/book/' + id,
             success: function() {
                 $('tbody').children().remove();
             getAllBooks();
             }
         });
     }










