(function() {
	'use strict';

	angular.module('skdevMD').controller('ActionCT', ActionCT);

	ActionCT.$inject = [ '$scope', '$log', '$http', '$mdDialog', 'actionData', 'actionId', '$mdToast','$location', 'HttpSV' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param $http
	 * @param $mdDialog
	 * @param actionDialog
	 * @param actionId
	 * @param $mdToast
	 * @returns
	 */
	function ActionCT($scope, $log, $http, $mdDialog, actionData, actionId, $mdToast, $location, HttpSV) {
		$log.debug('[ActionCT] Inicializando...');
		var self = this;

		self.hide = hide;

		self.execute = execute;

		self.values = {};

		self.options = {};

		self.loadOptionsFromEndpoint = loadOptionsFromEndpoint;
		
		var context = format('http://{}:{}/skdev/api', $location.host(), $location.port());
		
		function loadOptionsFromEndpoint(id,path) {
			HttpSV.get(format(path, self.values),{
				queryParams: {
					name: HttpSV.getProjectName()
				}
			}).then(function(data) {
				self.options[id] = data;
			});
		}

		function hide() {
			$mdDialog.hide();
		}

		function execute() {
			console.log(self.values);
			
			$http.post('http://localhost:8080/skdev/api/actions/' + actionId, self.values).success(function(data) {
				$mdDialog.hide();
				$mdToast.show($mdToast.simple().textContent('Ação executada com sucesso!').position("top right").hideDelay(3000));
			});
			
			hide();
			/*
			if(self.config.actionSuccess.showOnSuccessExecute) {
				$http.get(format('{}/api/actions/{}/success', context, actionId));
			}*/
		}

	}
})();