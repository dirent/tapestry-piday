let searchBox, indexP, digits;

function searchItUp() {
    let digits = searchBox.value();
    if( digits ) {
        indexP.html('Searching');
        loadJSON( "/pi:search/"+digits.trim(), gotResult );
    } else {
        indexP.html('Waiting for input');
    }
}

function gotResult(data) {
    let index = data.index;
    if( index < 0 ) {
        index = 'Not found';
    }
    indexP.html(index);
}

function setup() {
    noCanvas();

    searchBox = createInput('');
    indexP = createP('Waiting for input').class("result");
    searchBox.input(searchItUp);
}