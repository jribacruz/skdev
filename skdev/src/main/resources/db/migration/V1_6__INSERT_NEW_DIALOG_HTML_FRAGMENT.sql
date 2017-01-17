insert into sk_fragment(name, fragment) values('new.dialog.html', '<md-dialog aria-label="{{action.name}}">
    <form name="actionForm" ng-cloak>
        <md-dialog-content class="md-dialog-content">
            <h2 class="md-title">{{action.name}}</h2>
            <!-- ACTION COMPONENTS !-->
            
        </md-dialog-content>
        <md-dialog-actions layout="row">
            <md-button ng-click="actionCT.execute()" ng-disabled="actionForm.$invalid || !actionForm.$dirty">
                Executar
            </md-button>
            <md-button ng-click="actionCT.cancel()">
                Cancelar
            </md-button>
        </md-dialog-actions>
    </form>
</md-dialog>');