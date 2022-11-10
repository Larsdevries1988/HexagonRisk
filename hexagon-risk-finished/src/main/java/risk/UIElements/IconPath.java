package risk.UIElements;

public enum IconPath {
    ADD_LOCATION ("M22.85 27.15h2.3v-6h6v-2.3h-6v-6h-2.3v6h-6v2.3h6ZM24 43.6Q16.2 36.8 12.35 31 8.5 25.2 8.5 20.4q0-7.25 4.675-11.575Q17.85 4.5 24 4.5q6.15 0 10.825 4.325Q39.5 13.15 39.5 20.4q0 4.8-3.85 10.6T24 43.6Z"),
    ELIMINATE ("M24 27.15q-3.35 0-6.075 1.875T13.9 34h20.2q-1.25-3.15-4-5T24 27.15Zm-9.15-3.6 2.5-2.25 2.25 2.25 1.55-1.8-2.25-2.25 2.25-2.25-1.55-1.8-2.25 2.25-2.5-2.25-1.55 1.8 2.25 2.25-2.25 2.25Zm13.6 0 2.2-2.25 2.55 2.25 1.55-1.8-2.25-2.25 2.25-2.25-1.55-1.8-2.55 2.25-2.2-2.25-1.55 1.8 2.2 2.25-2.2 2.25ZM24 44q-4.15 0-7.8-1.575-3.65-1.575-6.35-4.275-2.7-2.7-4.275-6.35Q4 28.15 4 24t1.575-7.8Q7.15 12.55 9.85 9.85q2.7-2.7 6.35-4.275Q19.85 4 24 4t7.8 1.575q3.65 1.575 6.35 4.275 2.7 2.7 4.275 6.35Q44 19.85 44 24t-1.575 7.8q-1.575 3.65-4.275 6.35-2.7 2.7-6.35 4.275Q28.15 44 24 44Z"),
    EXPLORE ("m15.15 33.85 12.05-5.9q.25-.1.425-.275.175-.175.275-.425l5.9-12.05q.25-.5-.125-.875T32.8 14.2l-12.05 5.9q-.25.1-.425.275-.175.175-.275.425l-5.9 12.05q-.25.5.125.875t.875.125ZM24 26q-.85 0-1.425-.575Q22 24.85 22 24q0-.85.575-1.425Q23.15 22 24 22q.85 0 1.425.575Q26 23.15 26 24q0 .85-.575 1.425Q24.85 26 24 26Zm0 18q-4.1 0-7.75-1.575-3.65-1.575-6.375-4.3-2.725-2.725-4.3-6.375Q4 28.1 4 24t1.575-7.75q1.575-3.65 4.3-6.375 2.725-2.725 6.375-4.3Q19.9 4 24 4t7.75 1.575q3.65 1.575 6.375 4.3 2.725 2.725 4.3 6.375Q44 19.9 44 24t-1.575 7.75q-1.575 3.65-4.3 6.375-2.725 2.725-6.375 4.3Q28.1 44 24 44Z"),
    FLAG ("M11.5 42q-.65 0-1.075-.425Q10 41.15 10 40.5v-31q0-.65.425-1.075Q10.85 8 11.5 8h14.45q.55 0 .95.325.4.325.5.875l.7 3.1h10.4q.65 0 1.075.425Q40 13.15 40 13.8v15.5q0 .65-.425 1.075-.425.425-1.075.425H28.4q-.5 0-.925-.325-.425-.325-.525-.825l-.7-3.1H13V40.5q0 .65-.425 1.075Q12.15 42 11.5 42Z"),
    FOLDER ("M7.75 39q-1.05 0-1.9-.85Q5 37.3 5 36.25v-23.6q0-1.1.9-2 .9-.9 2-.9h12.7q.45 0 .875.2t.725.5l1.85 1.8H40.1q1 0 1.775.7.775.7.975 1.6h-32.7q-1.2 0-2.05.85-.85.85-.85 2v18.7q0 .25.125.375t.275.225l4.55-17.2q.2-.75.85-1.225.65-.475 1.4-.475H43.5q1.15 0 1.85.875.7.875.4 1.975L41.4 36.9q-.3 1.1-1.025 1.6-.725.5-1.875.5Z"),
    GAME ("M7.35 38q-1.9 0-2.975-1.275Q3.3 35.45 3.6 33.2L6 16.45q.4-2.65 2.475-4.55T13.2 10h21.65q2.65 0 4.725 1.9 2.075 1.9 2.475 4.55L44.4 33.2q.3 2.25-.775 3.525T40.65 38q-1.15 0-1.95-.375t-1.35-.925l-5.2-5.2h-16.3l-5.2 5.2q-.55.55-1.35.925T7.35 38ZM35 26q.8 0 1.4-.6.6-.6.6-1.4 0-.8-.6-1.4-.6-.6-1.4-.6-.8 0-1.4.6-.6.6-.6 1.4 0 .8.6 1.4.6.6 1.4.6Zm-4.25-6.5q.8 0 1.4-.6.6-.6.6-1.4 0-.8-.6-1.4-.6-.6-1.4-.6-.8 0-1.4.6-.6.6-.6 1.4 0 .8.6 1.4.6.6 1.4.6ZM15 25.75h2.5V22h3.75v-2.5H17.5v-3.75H15v3.75h-3.75V22H15Z"),
    GROUPS ("M1 35.6v-2.1q0-1.85 1.95-3t5.2-1.15q.55 0 1.1.025t1.05.125q-.35.75-.525 1.575Q9.6 31.9 9.6 32.8v2.8Zm12 0v-2.7q0-2.9 3.025-4.65Q19.05 26.5 24 26.5q4.95 0 7.975 1.75Q35 30 35 32.9v2.7Zm25.4 0v-2.8q0-.9-.175-1.725-.175-.825-.525-1.625.5-.05 1.05-.075.55-.025 1.1-.025 3.2 0 5.175 1.15Q47 31.65 47 33.5v2.1ZM8.15 27.75q-1.3 0-2.175-.9-.875-.9-.875-2.15 0-1.3.875-2.175.875-.875 2.175-.875 1.25 0 2.15.9.9.9.9 2.15t-.9 2.15q-.9.9-2.15.9Zm31.7 0q-1.25 0-2.15-.9-.9-.9-.9-2.15 0-1.3.9-2.175.9-.875 2.15-.875 1.3 0 2.175.9.875.9.875 2.15t-.875 2.15q-.875.9-2.175.9ZM24 25q-2.15 0-3.675-1.525T18.8 19.8q0-2.15 1.525-3.675T24 14.6q2.15 0 3.675 1.525T29.2 19.8q0 2.15-1.525 3.675T24 25Z"),
    HEXAGON ("M13.9 41.5 3.8 24 13.9 6.5h20.2L44.2 24 34.1 41.5Z"),
    LIST ("M7.5 34q-.65 0-1.075-.425Q6 33.15 6 32.5q0-.65.425-1.075Q6.85 31 7.5 31q.65 0 1.075.425Q9 31.85 9 32.5q0 .65-.425 1.075Q8.15 34 7.5 34Zm0-8.5q-.65 0-1.075-.425Q6 24.65 6 24q0-.65.425-1.075Q6.85 22.5 7.5 22.5q.65 0 1.075.425Q9 23.35 9 24q0 .65-.425 1.075-.425.425-1.075.425Zm0-8.5q-.65 0-1.075-.425Q6 16.15 6 15.5q0-.65.425-1.075Q6.85 14 7.5 14q.65 0 1.075.425Q9 14.85 9 15.5q0 .65-.425 1.075Q8.15 17 7.5 17Zm7 17v-3H42v3Zm0-8.5v-3H42v3Zm0-8.5v-3H42v3Z"),
    LIST_ALT ("M15 33.7q.6 0 1.05-.45.45-.45.45-1.05 0-.6-.45-1.05-.45-.45-1.05-.45-.6 0-1.05.45-.45.45-.45 1.05 0 .6.45 1.05.45.45 1.05.45Zm0-8.2q.6 0 1.05-.45.45-.45.45-1.05 0-.6-.45-1.05-.45-.45-1.05-.45-.6 0-1.05.45-.45.45-.45 1.05 0 .6.45 1.05.45.45 1.05.45Zm0-8.2q.6 0 1.05-.45.45-.45.45-1.05 0-.6-.45-1.05-.45-.45-1.05-.45-.6 0-1.05.45-.45.45-.45 1.05 0 .6.45 1.05.45.45 1.05.45Zm6.6 16.4h12.2v-3H21.6Zm0-8.2h12.2v-3H21.6Zm0-8.2h12.2v-3H21.6ZM9 42q-1.2 0-2.1-.9Q6 40.2 6 39V9q0-1.2.9-2.1Q7.8 6 9 6h30q1.2 0 2.1.9.9.9.9 2.1v30q0 1.2-.9 2.1-.9.9-2.1.9Z"),
    LOGOUT ("M9.45 43.25q-1.95 0-3.325-1.375Q4.75 40.5 4.75 38.55v-9.2h4.7v9.2h29.1V9.35H9.45v9.3h-4.7v-9.3Q4.75 7.4 6.125 6 7.5 4.6 9.45 4.6h29.1q1.95 0 3.35 1.4 1.4 1.4 1.4 3.35v29.2q0 1.95-1.4 3.325-1.4 1.375-3.35 1.375Zm11.9-8.1-3.45-3.4 5.35-5.4H4.75v-4.7h18.5l-5.35-5.4 3.45-3.4L32.5 24Z"),
    MANAGE_ACCOUNTS ("M20 23.2q-2.9 0-4.775-1.875-1.875-1.875-1.875-4.775 0-2.9 1.875-4.775Q17.1 9.9 20 9.9q2.9 0 4.775 1.875 1.875 1.875 1.875 4.775 0 2.9-1.875 4.775Q22.9 23.2 20 23.2ZM5 38.45v-3.8q0-1.55.825-2.775.825-1.225 2.225-1.825 2.85-1.3 5.825-2.075Q16.85 27.2 20 27.2h1q-.85 2.75-.65 5.625.2 2.875 1.15 5.625Zm28.2 1.65-.35-2.9q-.95-.2-1.825-.675-.875-.475-1.475-1.125l-2.4.65-.9-1.5 2.1-1.85q-.2-.55-.2-1.45 0-.9.2-1.5l-2.1-1.9.9-1.45 2.4.7q.6-.7 1.475-1.175.875-.475 1.825-.675l.35-2.9h1.9l.35 2.9q.9.2 1.8.675.9.475 1.5 1.125l2.4-.65.85 1.45-2.1 1.85q.25.65.25 1.525 0 .875-.25 1.475l2.1 1.85-.85 1.5-2.4-.65q-.65.65-1.525 1.125-.875.475-1.775.675l-.35 2.9Zm.9-5.05q1.75 0 2.8-1.075 1.05-1.075 1.05-2.725 0-1.7-1.075-2.75T34.1 27.45q-1.65 0-2.725 1.05-1.075 1.05-1.075 2.75 0 1.65 1.075 2.725Q32.45 35.05 34.1 35.05Z"),
    MILITARY_TECH ("M14.4 4.6h19.2v15.6q0 1.1-.575 2.05-.575.95-1.575 1.55l-6.9 4.05 1.35 4.85h6.05L27 36.3l1.95 6.1L24 38.7l-4.95 3.7 1.9-6.1-4.9-3.6h6.05l1.3-4.85-6.85-4q-1-.6-1.575-1.55-.575-.95-.575-2.1ZM23 6.85V24.9l1.15.6 1.15-.6V6.85Z"),
    MY_LOCATION ("M24 45.9q-.65 0-1.075-.425-.425-.425-.425-1.075v-2.25q-6.85-.7-11.4-5.25-4.55-4.55-5.25-11.4H3.6q-.65 0-1.075-.425Q2.1 24.65 2.1 24q0-.65.425-1.075Q2.95 22.5 3.6 22.5h2.25q.7-6.85 5.25-11.4 4.55-4.55 11.4-5.25V3.6q0-.65.425-1.075Q23.35 2.1 24 2.1q.65 0 1.075.425.425.425.425 1.075v2.25q6.85.7 11.4 5.25 4.55 4.55 5.25 11.4h2.25q.65 0 1.075.425.425.425.425 1.075 0 .65-.425 1.075-.425.425-1.075.425h-2.25q-.7 6.85-5.25 11.4-4.55 4.55-11.4 5.25v2.25q0 .65-.425 1.075-.425.425-1.075.425Zm0-6.7q6.25 0 10.725-4.475T39.2 24q0-6.25-4.475-10.725T24 8.8q-6.25 0-10.725 4.475T8.8 24q0 6.25 4.475 10.725T24 39.2Zm0-7.7q-3.15 0-5.325-2.175Q16.5 27.15 16.5 24q0-3.15 2.175-5.325Q20.85 16.5 24 16.5q3.15 0 5.325 2.175Q31.5 20.85 31.5 24q0 3.15-2.175 5.325Q27.15 31.5 24 31.5Z"),
    NEXT_PLAN ("M12.55 27.3h2.25q.35-3.15 2.725-5.275Q19.9 19.9 23.2 19.9q2.15 0 4.525 1.35Q30.1 22.6 31.65 25H26.9v2.3h8.5v-8.55h-2.25v4.7q-1.9-2.95-4.675-4.375Q25.7 17.65 23.2 17.65q-4.25 0-7.275 2.8-3.025 2.8-3.375 6.85ZM24 43q-3.9 0-7.375-1.5t-6.05-4.075Q8 34.85 6.5 31.375 5 27.9 5 24q0-3.95 1.5-7.425Q8 13.1 10.575 10.55 13.15 8 16.625 6.5 20.1 5 24 5q3.95 0 7.425 1.5Q34.9 8 37.45 10.55 40 13.1 41.5 16.575 43 20.05 43 24q0 3.9-1.5 7.375t-4.05 6.05Q34.9 40 31.425 41.5 27.95 43 24 43Z"),
    PARAGLIDING ("M24 33.45q-1.4 0-2.425-1.025T20.55 30q0-1.4 1.025-2.425T24 26.55q1.4 0 2.425 1.025T27.45 30q0 1.4-1.025 2.425T24 33.45ZM18.85 47.5v-7q-4.05-1.25-5.9-4.475Q11.1 32.8 10.9 28.85h2.25q.2 5.15 2.925 7.575Q18.8 38.85 24 38.85q5.2 0 7.925-2.425Q34.65 34 34.85 28.85h2.25q-.15 3.95-2.025 7.175Q33.2 39.25 29.15 40.5v7Zm-8.2-22L6 15.7q-.7.3-1.3.55-.6.25-1.05.25-.45 0-.8-.3-.35-.3-.35-.85v-7.2q0-3.1 6.3-5.375T24 .5q8.9 0 15.2 2.275 6.3 2.275 6.3 5.375v7.2q0 .55-.35.85-.35.3-.8.3-.45 0-1.05-.25-.6-.25-1.3-.55l-4.65 9.8H34.8l-3.1-12.85q-2-.25-3.925-.375Q25.85 12.15 24 12.15q-1.85 0-3.775.125-1.925.125-3.925.375L13.2 25.5Zm1.2-2L14.1 13q-1.85.4-3.2.8t-3 1.1Zm24.3 0 3.95-8.6q-1.65-.65-3-1.075-1.35-.425-3.2-.825Z"),
    PERSON_REMOVE ("M32.4 20.7v-2.3h10.7v2.3ZM18 23.35q-2.9 0-4.775-1.875Q11.35 19.6 11.35 16.7q0-2.9 1.875-4.75T18 10.1q2.9 0 4.775 1.85 1.875 1.85 1.875 4.75t-1.875 4.775Q20.9 23.35 18 23.35ZM3 38.6v-3.8q0-1.5.8-2.75t2.25-1.9q3.45-1.5 6.275-2.15 2.825-.65 5.675-.65 2.85 0 5.65.65 2.8.65 6.25 2.15 1.45.7 2.275 1.925T33 34.8v3.8Z"),
    PLAYER ("M11.3 34.7q3.1-1.95 6.125-2.9T24 30.85q3.55 0 6.65 1 3.1 1 6.1 2.85 2.1-2.75 2.95-5.275.85-2.525.85-5.425 0-7-4.775-11.775T24 7.45q-7 0-11.775 4.775T7.45 24q0 2.9.85 5.4.85 2.5 3 5.3ZM24 25.85q-3.05 0-5.1-2.05t-2.05-5.1q0-3 2.05-5.075T24 11.55q3.05 0 5.1 2.075t2.05 5.125q0 3-2.05 5.05T24 25.85Zm0 19.4q-4.4 0-8.275-1.675T8.95 39q-2.9-2.9-4.55-6.75T2.75 24q0-4.4 1.675-8.275T9 8.975Q11.9 6.1 15.75 4.4q3.85-1.7 8.3-1.7 4.4 0 8.25 1.7 3.85 1.7 6.725 4.575 2.875 2.875 4.575 6.75Q45.3 19.6 45.3 24t-1.7 8.25Q41.9 36.1 39.025 39t-6.75 4.575Q28.4 45.25 24 45.25Z"),
    PUBLIC ("M24 43q-3.95 0-7.425-1.5Q13.1 40 10.55 37.45 8 34.9 6.5 31.425 5 27.95 5 24q0-3.95 1.5-7.425Q8 13.1 10.55 10.55 13.1 8 16.575 6.5 20.05 5 24 5q3.95 0 7.425 1.5Q34.9 8 37.45 10.55 40 13.1 41.5 16.575 43 20.05 43 24q0 3.95-1.5 7.425Q40 34.9 37.45 37.45 34.9 40 31.425 41.5 27.95 43 24 43Zm-2.1-2.35V36.6q-1.75 0-2.925-1.25-1.175-1.25-1.175-3V30.2L7.7 20.15q-.2.95-.325 1.9T7.25 24q0 6.4 4.175 11.15t10.475 5.5Zm14.45-5.3q1.05-1.15 1.875-2.5t1.4-2.8q.575-1.45.85-2.975.275-1.525.275-3.075 0-5.2-2.85-9.475-2.85-4.275-7.65-6.225v.95q0 1.7-1.175 2.975Q27.9 13.5 26.15 13.5H21.9v4.25q0 .85-.65 1.4-.65.55-1.5.55h-4.1V24H28.3q.85 0 1.4.625.55.625.55 1.475v6.25h2.1q1.45 0 2.525.825t1.475 2.175Z"),
    REPLAY ("M24 43q-3.55 0-6.625-1.325t-5.4-3.65q-2.325-2.325-3.65-5.4Q7 29.55 7 26h2.25q0 6.15 4.3 10.45 4.3 4.3 10.45 4.3 6.15 0 10.45-4.3 4.3-4.3 4.3-10.45 0-6.15-4.2-10.45-4.2-4.3-10.35-4.3H23l3.6 3.6-1.55 1.55-6.35-6.35 6.4-6.4 1.55 1.55-3.8 3.8H24q3.55 0 6.625 1.325t5.4 3.65q2.325 2.325 3.65 5.4Q41 22.45 41 26t-1.325 6.625q-1.325 3.075-3.65 5.4t-5.4 3.65Q27.55 43 24 43Z"),
    SAVE ("M9.9 41q-1.2 0-2.05-.85Q7 39.3 7 38.1V9.9q0-1.2.85-2.05Q8.7 7 9.9 7h22.6q.55 0 1.075.225.525.225.975.625l5.6 5.6q.4.45.625.975Q41 14.95 41 15.5v22.6q0 1.2-.85 2.05-.85.85-2.05.85ZM24 34.35q1.8 0 3.1-1.275t1.3-3.125q0-1.85-1.275-3.15Q25.85 25.5 24 25.5q-1.8 0-3.1 1.3t-1.3 3.1q0 1.85 1.275 3.15 1.275 1.3 3.125 1.3ZM13.95 18.9H27.4q.65 0 1.05-.425t.4-1.025v-3.5q0-.6-.4-1.025-.4-.425-1.05-.425H13.95q-.6 0-1.025.425-.425.425-.425 1.025v3.5q0 .6.425 1.025.425.425 1.025.425Z"),
    SEND ("M6 40V27.75L21.1 24 6 20.15V8l38 16Z"),
    SHIPPING ("M11.1 39.1q-2.3 0-3.925-1.625T5.55 33.55H2.7V11.9q0-1.2.85-2.05Q4.4 9 5.6 9h27.9v7.85h4.75l7.05 9.45v7.25h-3.25q0 2.3-1.625 3.925T36.45 39.1q-2.3 0-3.9-1.625t-1.6-3.925h-14.3q0 2.3-1.625 3.925T11.1 39.1Zm0-2.3q1.4 0 2.35-.95.95-.95.95-2.3 0-1.35-.95-2.325-.95-.975-2.35-.975-1.35 0-2.3.975-.95.975-.95 2.325t.95 2.3q.95.95 2.3.95Zm25.4 0q1.35 0 2.3-.95.95-.95.95-2.3 0-1.35-.95-2.325-.95-.975-2.3-.975-1.4 0-2.35.975-.95.975-.95 2.325t.95 2.3q.95.95 2.35.95Zm-3-9.75h9.55l-5.95-7.9h-3.6Z"),
    SWORDS ("m38.45 43.6-6.2-6.2-4.4 4.4-2.15-2.15q-.85-.85-.85-2.1t.85-2.1l9.95-9.95q.85-.85 2.1-.85t2.1.85L42 27.65l-4.4 4.4 6.15 6.2q.45.45.45 1.05 0 .6-.45 1.05l-3.2 3.25q-.45.45-1.05.45-.6 0-1.05-.45ZM44 11.8 21.35 34.45l.95 1q.85.85.85 2.1t-.85 2.1l-2.15 2.15-4.4-4.4-6.2 6.2q-.45.45-1.05.45-.6 0-1.05-.45L4.2 40.35q-.45-.45-.45-1.05 0-.6.45-1.05l6.2-6.2-4.4-4.4 2.15-2.15q.85-.85 2.1-.85t2.1.85l1 .95L36 3.8h8Zm-28 7.8 1.9-1.9 1.9-1.9-1.9 1.9Zm-2.1 2.1L4 11.8v-8h8l9.9 9.9-2.1 2.1-9.05-9H7v3.75l9 9.05Zm5.25 10.6L41 10.55V6.8h-3.75L15.4 28.55Zm0 0-1.85-1.9-1.9-1.85 1.9 1.85 1.85 1.9Z"),
    TUNE ("M22 41.5V31.05h2.3v4.1h17.2v2.25H24.3v4.1ZM6.5 37.4v-2.25h11.25v2.25Zm9-8.2v-4.05h-9v-2.3h9V18.7h2.25v10.5Zm6.5-4.05v-2.3h19.5v2.3Zm8.25-8.2V6.5h2.25v4.1h9v2.25h-9v4.1ZM6.5 12.85V10.6H26v2.25Z"),
    WORKSPACE_PREMIUM ("m21.1 26 2.9-2.15L26.85 26q.45.35.9.05t.3-.85l-1.1-3.55L30 19.3q.4-.35.225-.85-.175-.5-.725-.5h-3.65l-1.15-3.7q-.15-.5-.7-.525-.55-.025-.7.525l-1.2 3.7h-3.6q-.55 0-.725.5-.175.5.225.85l3.05 2.35-1.1 3.55q-.15.55.3.85.45.3.85-.05Zm-6.9 19.35q-.75.25-1.375-.2T12.2 43.9V30.8q-2.25-2.35-3.225-5.15Q8 22.85 8 20q0-6.8 4.6-11.4Q17.2 4 24 4q6.8 0 11.4 4.6Q40 13.2 40 20q0 2.85-.975 5.65-.975 2.8-3.225 5.15v13.1q0 .8-.625 1.25-.625.45-1.375.2l-9.8-3.3ZM24 33q5.45 0 9.225-3.775Q37 25.45 37 20q0-5.45-3.775-9.225Q29.45 7 24 7q-5.45 0-9.225 3.775Q11 14.55 11 20q0 5.45 3.775 9.225Q18.55 33 24 33Z");
    public final String path;

    IconPath(String path){
        this.path = path;
    }

}