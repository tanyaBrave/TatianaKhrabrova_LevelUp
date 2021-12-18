package selenium.locators;

public final class XpathLocators {

    public static final String LOGIN_FIELD = "//input[@data-testid='login-input']";
    public static final String PASSWORD_FIELD = "//input[@data-testid='password-input']";
    public static final String RECEIVER_FIELD = "//*[@data-name='to']//input[@type='text']";
    public static final String SUBJECT_FIELD = "//input[@name='Subject']";
    public static final String LETTER_CONTENT_FIELD = "//*[@role='textbox']";

    public static final String PASSWORD_BUTTON = "//button[@data-testid='enter-password']";
    public static final String SIGN_IN_BUTTON = "//button[@data-testid='login-to-mail']";
    public static final String LOG_OUT_BUTTON = "";
    public static final String PROFILE_BUTTON = "//*[@data-testid='whiteline-account']";
    public static final String WRITE_LETTER_BUTTON = "//a[@href='/compose/']";
    public static final String SEND_LETTER_BUTTON = "//*[@title='Отправить']";
    public static final String SAVE_DAFT_BUTTON = "//*[@title='Сохранить']";
    public static final String DELETE_LETTER_BUTTON = "//*[@title='Удалить']";
    public static final String DRAFT_FOLDER_BUTTON = "//a[@href='/drafts/']";
    public static final String OUTBOX_FOLDER_BUTTON = "//a[@href='/sent/']";
    public static final String TOMYSELF_FOLDER_BUTTON = "//a[@href='/tomyself/']";
    public static final String TRASH_FOLDER_BUTTON = "//a[@href='/trash/']";
    public static final String TEST_FOLDER_BUTTON = "//a[@href='/1/']";

    public static final String REMEMBER_ME_CHECKBOX = "//label[@data-testid='mail-remember']";
    public static final String CHECKBOX = "//input[@type='checkbox']";



}
