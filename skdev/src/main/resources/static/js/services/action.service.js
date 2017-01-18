(function() {
	'use strict';

	angular.module("skdevMD").factory('actionSV', actionSV);

	actionSV.$inject = [ '$log', '$http', '$location', '$mdDialog', '$window' ];

	/**
	 * 
	 * @param $log
	 * @param $mdToast
	 * @returns
	 */
	function actionSV($log, $http, $location, $mdDialog, $window) {
		$log.debug('[actionSV] Inicializando... ');

		var origin = new URI($location.absUrl());

		var Action = function() {
			var self = this;
			self.id = 0;
			self.name = "";
			self.description = "";
			self.dialogHTML = "";
			self.executeJS = "";
			self.templates = [];
			self.groups = [];
		}

		var service = {
			load : load,
			newAction : newAction,
			insert : insert,
			update : update,
			run : run,
			showActionInfo : showActionInfo,
			goTo : goTo,
			deleteAction: deleteAction
		};

		return service;

		function load(id) {
			var loadActionURL = origin.segment([ 'skdev', 'api', 'actions', new String(id) ]).href();
			$log.debug(format('[actionSV] load={}', loadActionURL));
			return $http.get(loadActionURL);
		}
		
		function deleteAction(id) {
			var deleteActionURL = origin.segment([ 'skdev', 'api', 'actions', new String(id) ]).href();
			$log.debug(format('[actionSV] delete={}', deleteActionURL));
			return $http.delete(deleteActionURL);
		}

		function newAction() {
			return new Action();
		}

		function insert(eAction) {
			var insertActionURL = origin.segment([ 'skdev', 'api', 'actions' ]).href();
			return $http.post(insertActionURL, eAction);
		}

		function update(eAction) {
			var updateActionURL = origin.segment([ 'skdev', 'api', 'actions', new String(eAction.id) ]).href();
			return $http.put(updateActionURL, eAction);
		}
		
		

		function run(eAction) {
			$log.debug(format('[actionSV] run: {}', eAction.name));
			var parentEl = angular.element(document.body);
			$mdDialog.show({
				parent : parentEl,
				template : eAction.dialogHTML,
				controller : 'ActionCT',
				clickOutsideToClose : true,
				locals : {
					eAction : eAction
				}
			});
		}

		function showActionInfo(action) {
			$log.debug(format('[actionSV] showActionInfo: {}', action.name));
			var parentEl = angular.element(document.body);
			return $mdDialog.show({
				parent : parentEl,
				templateUrl : '/skdev/partials/action.info.dialog.html',
				controller : 'ActionInfoCT',
				controllerAs : 'actionInfoCT',
				clickOutsideToClose : true,
				locals : {
					action : action
				}
			});
		}

		function goTo(id) {
			var goToURL = origin.segment([ 'skdev', 'actions', new String(id) ]).href();
			$log.debug('[actionSV] goTo: ' + goToURL);
			$window.location.href = goToURL;
		}
	}

})();