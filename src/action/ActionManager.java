package action;

public class ActionManager {

    private NewAction newAction;
    private InfoAction infoAction;
    private RemoveAction removeAction;
    private AuthorAction authorAction;
    private ThemeAction themeAction;
    private SlideShowAction slideShowAction;
    private NextSlideAction nextSlideAction;
    private PreviousSlideAction previousSlideAction;
    private EditShowAction editShowAction;
    private AddSlotAction addSlotAction;
    private RemoveSlotAction removeSlotAction;
    private MoveSlotAction moveSlotAction;
    private SelectSlotAction selectSlotAction;
    private ColorStrokeAction colorStrokeAction;
    private ColorSpaceAction colorSpaceAction;
    //private SolidStrokeAction solidStrokeAction;
    //private DashedStrokeAction dashedStrokeAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private ShareAction shareAction;
    private SlotTekst slotTekst;
    private SlotMultimedia slotMultimedia;
    private OpenEditorAction openEditorAction;
    private SaveProjectAction saveProjectAction;
    private OpenProjectAction openProjectAction;
    private SaveWorkspaceAction saveWorkspaceAction;
    private OpenWorkspaceAction openWorkspaceAction;
    private SavePresentationAction savePresentationAction;
    private OpenPresentationAction openPresentationAction;

    public ActionManager(){
        initialise();
    }

    private void initialise(){
        newAction = new NewAction();
        infoAction = new InfoAction();
        removeAction = new RemoveAction();
        authorAction = new AuthorAction();
        themeAction = new ThemeAction();
        slideShowAction = new SlideShowAction();
        nextSlideAction = new NextSlideAction();
        previousSlideAction = new PreviousSlideAction();
        editShowAction = new EditShowAction();
        addSlotAction = new AddSlotAction();
        removeSlotAction = new RemoveSlotAction();
        moveSlotAction = new MoveSlotAction();
        colorStrokeAction = new ColorStrokeAction();
        colorSpaceAction = new ColorSpaceAction();
        selectSlotAction =  new SelectSlotAction();
        undoAction = new UndoAction();
        redoAction = new RedoAction();
        shareAction = new ShareAction();
        slotTekst = new SlotTekst();
        slotMultimedia = new SlotMultimedia();
        openEditorAction = new OpenEditorAction();
        saveProjectAction = new SaveProjectAction();
        openProjectAction = new OpenProjectAction();
        saveWorkspaceAction = new SaveWorkspaceAction();
        openWorkspaceAction = new OpenWorkspaceAction();
        savePresentationAction = new SavePresentationAction();
        openPresentationAction = new OpenPresentationAction();
    }


    public NewAction getNewAction() {
        return newAction;
    }

    public void setNewAction(NewAction newAction) {
        this.newAction = newAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public RemoveAction getRemoveAction() {
        return removeAction;
    }

    public void setRemoveAction(RemoveAction removeAction) {
        this.removeAction = removeAction;
    }

    public AuthorAction getAuthorAction() {
        return authorAction;
    }

    public ThemeAction getThemeAction() {
        return themeAction;
    }

    public SlideShowAction getSlideShowAction() {
        return slideShowAction;
    }

    public NextSlideAction getNextSlideAction() {
        return nextSlideAction;
    }

    public PreviousSlideAction getPreviousSlideAction() {
        return previousSlideAction;
    }

    public EditShowAction getEditShowAction() {
        return editShowAction;
    }

    public AddSlotAction getAddSlotAction() {
        return addSlotAction;
    }

    public RemoveSlotAction getRemoveSlotAction() {
        return removeSlotAction;
    }

    public MoveSlotAction getMoveSlotAction() {
        return moveSlotAction;
    }

    public ColorStrokeAction getColorStrokeAction() {
        return colorStrokeAction;
    }

    public ColorSpaceAction getColorSpaceAction() {
        return colorSpaceAction;
    }

    public SelectSlotAction getSelectSlotAction() {
        return selectSlotAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public ShareAction getShareAction() {
        return shareAction;
    }

    public SlotTekst getSlotTekst() {
        return slotTekst;
    }

    public SlotMultimedia getSlotMultimedia() {
        return slotMultimedia;
    }

    public OpenEditorAction getOpenEditorAction() {
        return openEditorAction;
    }

    public SaveProjectAction getSaveProjectAction() {
        return saveProjectAction;
    }

    public void setSaveProjectAction(SaveProjectAction saveProjectAction) {
        this.saveProjectAction = saveProjectAction;
    }

    public OpenProjectAction getOpenProjectAction() {
        return openProjectAction;
    }

    public SaveWorkspaceAction getSaveWorkspaceAction() {
        return saveWorkspaceAction;
    }

    public OpenWorkspaceAction getOpenWorkspaceAction() {
        return openWorkspaceAction;
    }

    public SavePresentationAction getSavePresentationAction() {
        return savePresentationAction;
    }

    public OpenPresentationAction getOpenPresentationAction() {
        return openPresentationAction;
    }
}
