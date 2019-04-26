function timeToEnglish(sinceMidnight) {
    // Use numerals, except specifically the following words – midnight , noon , past , til , half , quarter
    // if given 30 , return "half past midnight" . If given 75 , return "quarter past 1 am" . 
    // If given 710 , return "10 til noon" . If given 1000 , return "20 til 5 pm" .
    if(sinceMidnight%60 === 0)
        return "midnight";
    if(sinceMidnight%60 === 12)
        return "highnoon";

    let minutes = sinceMidnight%60;
    let hours = Math.floor(sinceMidnight/60);
    let modifier;
    if(minutes <= 30) {
        modifier = "past"
        hours = Math.floor(sinceMidnight/60);
    } else {
        modifier = "til'";
        hours = Math.ceil(sinceMidnight/60);
    }
    // 40 => 20, 45 => 15
    const timeOfDay = (hours < 12) ? "AM" : "PM";
    hours = (hours > 12) ? (hours%12) : hours;
    minutes = (minutes > 30) ? 60 - minutes : minutes;
    const minutesMap = {
        30: "half",
        15: "quarter",
        45: "quarter"
    }
    const hoursMap = {
        0: "midnight",
        12: "noon"
    };

    if(minutesMap[minutes])
        minutes = minutesMap[minutes];
    if(hoursMap[hours])
        hours = hoursMap[hours];
    else
        hours = `${hours} ${timeOfDay}`;
        
    return `${minutes} ${modifier} ${hours}`;   

    
}    

    

console.log(timeToEnglish(0));